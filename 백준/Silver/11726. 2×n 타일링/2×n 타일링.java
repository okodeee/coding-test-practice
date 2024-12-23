import java.io.*;

/*
 * (n-1) 타일에 2*1 타일이 세로로 하나 붙음
 * + (n-2) 타일에 1*2 타일이 가로로 두 개 붙음
 * = dp[n] = dp[n-1] + dp[n-2]
 *
 * 런타임 에러: 잘못된 배열 인덱스 찹조 신경쓰기
 */
public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // dp[2] 초기화를 위해 int[n] 대신 최대 값 넣음
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(tile(n));
    }

    public static int tile(int n) {
        if (dp[n] == 0)
            dp[n] = (tile(n - 1) + tile(n - 2)) % 10007;
        return dp[n];
    }
}
