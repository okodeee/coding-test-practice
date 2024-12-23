import java.io.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[0] = dp[1] = 0;

        System.out.println(min(N));
    }

    public static int min(int N) {
        if (N > 1 && dp[N] == 0) {
            if (N % 6 == 0) {
                dp[N] = Math.min(min(N / 3), Math.min(min(N / 2), min(N - 1))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(min(N / 3), min(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(min(N / 2), min(N - 1)) + 1;
            } else {
                dp[N] = min(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
