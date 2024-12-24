import java.io.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(num(n));
        }
    }

    public static int num(int n) {
        if (dp[n] == 0)
            dp[n] = num(n - 1) + num(n - 2) + num(n - 3);
        return dp[n];
    }
}
