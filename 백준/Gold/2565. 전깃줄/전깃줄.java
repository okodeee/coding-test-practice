import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());
        int[] lines = new int[501];
        int[] result = new int[501];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A =  Integer.parseInt(st.nextToken());
            lines[A] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < 501; i++) {
            if (lines[i] != 0) result[i] = 1;   // 존재하는 전깃줄만
            for (int j = 1; j < i; j++) {
                if (lines[i] > lines[j] && result[i] < result[j] + 1) {
                    result[i] = result[j] + 1;
                }

            }
            max = Math.max(max, result[i]);
        }

        System.out.println(N - max);
    }
}