import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            if (coins[i] < k + 1) dp[coins[i]] = 1;
        }


        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[j] > 0 && dp[i - coins[j]] > 0) {
                    if (dp[i] == 0) {
                        dp[i] = dp[i - coins[j]] + 1;
                        continue;
                    }

                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
//        for (int i = 0; i <= k; i++)
            System.out.println(dp[k] == 0 ? -1 : dp[k]);
    }
}