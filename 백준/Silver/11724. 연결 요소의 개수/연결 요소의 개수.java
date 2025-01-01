import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int N, M;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                result++;
                dfs(i);
            }
        }

        System.out.println(result);
    }

    static void dfs(int n) {
        visited[n] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[n][i] == 1 && !visited[i]) dfs(i);
        }
    }
}