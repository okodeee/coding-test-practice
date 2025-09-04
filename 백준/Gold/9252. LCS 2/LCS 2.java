import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new  int[str1.length() + 1][str2.length() + 1];

        // LCS 구하기
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int length = dp[str1.length()][str2.length()];
        System.out.println(length);
        if (length == 0) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        int x = str1.length();
        int y = str2.length();
        while (length > 0) {
            if (dp[x - 1][y] == length) {
                x--;
            } else if (dp[x][y - 1] == length) {
                y--;
            } else {
                sb.append(str1.charAt(x - 1));
                x--;
                y--;
                length--;
            }
        }

        System.out.println(sb.reverse());
    }
}