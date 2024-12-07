import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static int[][] graph;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();

    public static void dfs(int V) {
        visit[V] = true;
        sb.append(V).append(" ");

        for (int i = 1; i <= N; i++) {
            if (graph[V][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int V) {
        q.add(V);
        visit[V] = true;

        while (!q.isEmpty()) {
            V = q.poll();
            sb.append(V).append(" ");

            for (int i = 1; i <= N; i++) {
                if (graph[V][i] == 1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = graph[v2][v1] = 1;
        }
        dfs(V);
        sb.append('\n');
        visit = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }
}
