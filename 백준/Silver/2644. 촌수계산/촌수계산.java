import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] relation;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        relation = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            relation[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            relation[u].add(v);
            relation[v].add(u);
        }



        dfs(start, end, 0);

        System.out.println(result);
    }

    static void dfs(int start, int end, int count) {
        if (start == end) {
            result = count;
            return;
        }

        visited[start] = true;

        for (int i = 0; i < relation[start].size(); i++) {
            int next = relation[start].get(i);
            if (!visited[next]) {
                dfs(next, end, count + 1);
            }
        }
    }
}