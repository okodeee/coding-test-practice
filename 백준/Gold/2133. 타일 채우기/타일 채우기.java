import java.io.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];

        // N이 홀수일 경우, 2x1 or 1x2의 타일로 채울 수 없기 때문에 0을 출력하고 return
        if (n % 2 != 0) {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += (dp[j] * 2);
            }
        }

        System.out.println(dp[n]);
    }
}