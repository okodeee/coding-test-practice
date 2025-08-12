import java.io.*;
import java.util.*;

/*
 * 이항 계수 - 파스칼의 법칙
 * nCk + nC(k+1) = (n+1)C(k+1)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] bi = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            bi[i][0] = 1;
        }

        // DP
        bi[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (i == j) {
                    bi[i][j] = 1;
                    break;
                }
                bi[i][j] = (bi[i - 1][j - 1] + bi[i - 1][j]) % 10007;
            }
        }

        System.out.println(bi[N][K]);
    }
}