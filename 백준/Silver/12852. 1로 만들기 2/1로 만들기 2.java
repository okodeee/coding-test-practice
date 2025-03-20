import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][2];

        if (N >= 2) {
            dp[2][0] = 1;
            dp[2][1] = 1;
        }
        if (N >= 3) {
            dp[3][0] = 1;
            dp[3][1] = 1;
        }
        for (int i = 4; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
            dp[i][1] = i - 1;
            if (i % 2 == 0 && dp[i][0] > dp[i / 2][0] + 1) {
                dp[i][0] = dp[i / 2][0] + 1;
                dp[i][1] = i / 2;
            }
            if (i % 3 == 0 && dp[i][0] > dp[i / 3][0] + 1) {
                dp[i][0] = dp[i / 3][0] + 1;
                dp[i][1] = i / 3;
            }
        }
        int num = N;
        while (num > 1) {
            sb.append(num).append(" ");
            num = dp[num][1];
        }
        sb.append(1);
        System.out.println(dp[N][0]);
        System.out.println(sb);
    }
}