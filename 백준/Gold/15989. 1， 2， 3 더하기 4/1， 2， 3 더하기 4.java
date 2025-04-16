import java.io.*;
import java.util.*;

/* 
 * 중복 조합 구하기 (순서 고려하지 않음)
 * 항상 작은 수부터 더하는 방식으로 조합 구성
 * => 조합 순서를 고정 (오름차순)
 * 테스트케이스가 여러 개, 미리 DP 배열 계산
 * => 메모이제이션 & 선계산
 */
public class Main {
    static final int MAX = 10000;
    static int[][] dp = new int[MAX + 1][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        preprocess();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }
    }

    static void preprocess() {
        dp[1][1] = 1;

        dp[2][1] = 1;
        dp[2][2] = 1;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 10000; i++) {
            // 마지막이 1인 조합
            dp[i][1] = 1;

            // 마지막이 2인 조합
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];

            // 마지막이 3인 조합
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }
    }
}