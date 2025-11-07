import java.io.*;
import java.util.*;


public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[][] dp;  // dp[node][0]: 해당 노드 얼리어답터 X, dp[node][1]: 해당 노드 얼리어답터 O

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new List[N + 1]; // 자식 노드 저장
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {   // 친구 관계는 양방향
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N + 1];
        dp = new int[N + 1][2];

        dfs(1);    // 루트 노드

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int node) {
        visited[node] = true;

        dp[node][0] = 0;
        dp[node][1] = 1;

        for (int child : graph[node]) {
            if (!visited[child]) {
                dfs(child);

                // 현재 노드가 얼리어답터가 아니면 자식 노드는 모두 얼리어답터
                dp[node][0] += dp[child][1];

                // 현재 노드가 얼리어답터면 자식 노드는 얼리어답터여도 되고 아니어도 됨 (최솟값으로)
                dp[node][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}