import java.io.*;
import java.util.*;

public class Main {
    static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(modularExponentiation(A, B, C));
    }

    // 분할 정복을 이용한 거듭제곱 연산 (O(log B))
    static long modularExponentiation(long base, long exp, long mod) {
        if (exp == 0) return 1;  // A^0 = 1
        if (exp == 1) return base % mod;  // A^1 = A % C

        long half = modularExponentiation(base, exp / 2, mod);
        half = (half * half) % mod;  // (A^(B/2) % C) * (A^(B/2) % C) % C

        return (exp % 2 == 0) ? half : (half * base) % mod;
    }
}
