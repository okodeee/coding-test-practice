import java.io.*;
import java.util.*;

public class Main {
    static int[][][] memo = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            int aa = a + 50;
            int bb = b + 50;
            int cc = c + 50;

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + dp(aa, bb, cc));
        }

    }

    static int dp(int a, int b, int c) {
        if (memo[a][b][c] != 0) return memo[a][b][c];

        if (a <= 50 || b <= 50 || c <= 50) {
            return memo[a][b][c] = 1;
        }

        if (a > 70 || b > 70 || c > 70) {
            return memo[a][b][c] = dp(70, 70, 70);
        }

        if (a < b && b < c) {
            return memo[a][b][c] = dp(a, b, c-1) + dp(a, b-1, c-1) - dp(a, b-1, c);
        }

        return memo[a][b][c] = dp(a-1, b, c) + dp(a-1, b-1, c) + dp(a-1, b, c-1) - dp(a-1, b-1, c-1);
    }
}