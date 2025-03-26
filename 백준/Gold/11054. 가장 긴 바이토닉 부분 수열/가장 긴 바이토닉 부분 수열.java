import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] up = new int[N];
        int[] down = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            up[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && up[i] < up[j] + 1) {
                    up[i] = up[j] + 1;
                }

            }
        }

        for (int i = N - 1; i >= 0; i--) {
            down[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (A[i] > A[j] && down[i] < down[j] + 1) {
                    down[i] = down[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, up[i] + down[i]);
        }

        System.out.println(max - 1);
    }
}