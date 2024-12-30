import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물건의 개수
        int K = Integer.parseInt(st.nextToken()); // 배낭의 최대 무게
        int[] W = new int[N + 1];
        int[] V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken()); // 무게
            V[i] = Integer.parseInt(st.nextToken()); // 가치
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= K; w++) {
                if (W[i] > w) {
                    dp[i][w] = dp[i - 1][w]; // 물건을 넣을 수 없을 때
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], V[i] + dp[i - 1][w - W[i]]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}