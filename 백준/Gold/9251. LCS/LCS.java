import java.io.*;

/*
 * LCS (최장 공통 부분 수열)
 * if (Xi == Yj), LCS(Xi, Yi) = LCS(Xi-1, Yi-1) + 1
 * if (Xi != Yj), LCS(Xi, Yi) = max(LCS(Xi-1, Yj), LCS(Xi, Yj-1))
 */
public class Main {
    // Integer 배열은 null로 초기화
    static Integer[][] dp;
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        dp = new Integer[str1.length()][str2.length()];

        System.out.println(lcs(str1.length() - 1, str2.length() - 1));
    }

    public static int lcs(int x, int y) {
        if (x < 0 || y < 0)
            return 0;
        if (dp[x][y] == null) {
            if (str1.charAt(x) == str2.charAt(y)) {
                dp[x][y] = lcs(x - 1, y - 1) + 1;
            } else {
                dp[x][y] = Math.max(lcs(x - 1, y), lcs(x, y - 1));
            }
        }

        return dp[x][y];
    }
}