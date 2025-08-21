import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static List<Integer>[] relation;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        relation = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            relation[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            relation[B].add(A);
        }

        int[] count =  new int[N + 1];
        for (int i = 1; i <= N; i++) {
            count[i] = bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, count[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (count[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
    
    static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int next : relation[curr]) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        return count;
    }
}