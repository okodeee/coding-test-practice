import java.io.*;

/*
 * 파도반 수열
 * P(1) = P(2) = P(3) = 1
 * P(n) = P(n-2) + P(n-3), n >= 4
 */

public class Main {
    static long[] arr = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        arr[1] = arr[2] = arr[3] = 1;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(padovan(N));
        }
    }

    public static long padovan(int n) {
        if (arr[n] == 0) arr[n] = padovan(n-2) + padovan(n-3);

        return arr[n];
    }
}