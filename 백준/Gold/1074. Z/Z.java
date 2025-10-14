import java.io.*;
import java.util.*;

public class Main {
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        split(0, 0, (int) Math.pow(2, N), 0);
    }

    static void split(int startR, int startC, int n, int startNum) {
        if (n == 1) {
            System.out.println(startNum);
            return;
        }


        int half = n / 2;

        if (r < startR + half && c < startC + half) {
            // 1. 북서
            split(startR, startC, half, startNum);
        } else if (r < startR + half && c >= startC + half) {
            // 2. 북동
            split(startR, startC + half, half, startNum + half * half);
        } else if (r >= startR + half && c < startC + half) {
            // 3. 남서
            split(startR + half, startC, half, startNum + half * half * 2);
        } else if (r >= startR + half && c >= startC + half) {
            // 4. 남동
            split(startR + half, startC + half, half, startNum + half * half * 3);
        }
    }
}