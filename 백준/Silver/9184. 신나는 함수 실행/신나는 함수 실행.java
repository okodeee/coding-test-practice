import java.io.*;
import java.util.*;

// 불필요한 a+50 변환 제거 (0 <= a, b, c <= 20) 범위 조정
// 배열 크기를 101x101x101 -> 21x21x21로 줄임
public class Main {
    static int[][][] memo = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }

    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (memo[a][b][c] != 0) return memo[a][b][c]; // 이미 계산된 값 반환

        if (a < b && b < c) {
            return memo[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }

        return memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}