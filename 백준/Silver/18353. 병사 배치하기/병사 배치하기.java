import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] soldiers = new int[N];
        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            soldiers[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (soldiers[i] < soldiers[j] && result[i] < result[j] + 1) {
                    result[i] = result[j] + 1;
                }

            }
            max = Math.max(max, result[i]);
        }

        System.out.println(N - max);
    }
}