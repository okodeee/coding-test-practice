import java.io.*;
import java.util.*;

// 이분 그래프이면서 토끼와 사자가 다른 그래프에 속한다면 영원히 만날 수 없다
public class Main {
    static List<Integer>[] graph;
    static int[] binaryGroup;
    static boolean possible = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        binaryGroup = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (binaryGroup[i] == 0) {
                setGroup(i);
            }
        }

        if (!possible) {
            System.out.println(0);
            return;
        }

        int group1 = 0, group2 = 0;
        for (int i = 1; i <= N; i++) {
            if (binaryGroup[i] == 1) {
                group1++;
            } else {
                group2++;
            }
        }

        // group1 위치 하나 지정 * group2 위치 하나 지정 * 토끼와 사자 group1, 2 지정
        System.out.println(group1 * group2 * 2);
    }

    static void setGroup(int node) {
        Queue<Integer> q = new LinkedList<>();

        binaryGroup[node] = 1;
        q.add(node);

        while(!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph[curr]) {
                if (binaryGroup[next] == binaryGroup[curr]) {    // 이분그래프 불가능
                    possible = false;
                    return;
                } else if (binaryGroup[next] == 0) {
                    binaryGroup[next] = 3 - binaryGroup[curr];
                    q.add(next);
                }
            }
        }
    }
}