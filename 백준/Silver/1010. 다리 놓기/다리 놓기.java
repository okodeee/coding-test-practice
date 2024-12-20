import java.io.*;
import java.util.StringTokenizer;

/*
 * 조합 공식의 성질
 * 1. (n+1)C(r+1) = nCr + nC(r+1)
 * 2. nC0 = nCn = 1
 */
public class Main {
    static int[][] arr = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(combi(M, N));
        }
    }

    public static int combi(int n, int r) {
        if (arr[n][r] > 0)
            return arr[n][r];
        if (n == r || r == 0)
            return arr[n][r] = 1;
        return arr[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}
