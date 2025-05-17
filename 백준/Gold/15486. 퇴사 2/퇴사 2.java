import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N + 1];
        int[] pay = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2];
        for (int i = N; i > 0; i--) {
            // i일 포함x

            // i일 포함o
            int include = 0;
            if (i + time[i] <= N + 1) {
                include = pay[i] + dp[i + time[i]];
            }

            dp[i] = Math.max(dp[i + 1], include);
        }

        System.out.println(dp[1]);
    }
}