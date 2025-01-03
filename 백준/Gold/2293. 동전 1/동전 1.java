import java.io.*;
import java.util.StringTokenizer;

/*
 * dp[i] += dp[i - coin]
 * 즉, i원을 만들기 위해 coin을 추가했을 때,
 * 나머지 금액(i - coin)을 만드는 조합 수를 더함
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 범위 설정 주의하기 
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        dp[0] = 1;

        // 간단한 반복문
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(dp[k]);
    }
}