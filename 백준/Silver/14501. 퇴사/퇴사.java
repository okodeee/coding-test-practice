import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 남은 일 수
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken()); // 상담 기간
            P[i] = Integer.parseInt(st.nextToken()); // 금액
        }

        int[] dp = new int[N + 2]; // N+1 을 참조하기 때문에

        for (int i = N; i > 0; i--) {
            if (i + T[i] <= N + 1) {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}