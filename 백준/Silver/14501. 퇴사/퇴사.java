import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = N; i > 0; i--) {
            if (i + T[i] <= N + 1) {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
        sc.close();
    }
}