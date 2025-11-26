import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] children = new int[N];
        for (int i = 0; i < N; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        dp[0] = 1;

        int result = 0;

        for (int i = 1; i < N; i++) {   // i번쩨 아이까지의 LIS 구하기
            dp[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (children[i] > children[j]) {    // 업데이트
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            result = Math.max(result, dp[i]);

        }

        System.out.println(N - result);
    }
}