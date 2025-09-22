import java.io.*;
import java.util.*;


public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int result = 0;
        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                array[i][j] = str.charAt(j) - '0';
                if (array[i][j] == 1) {
                    result = 1;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (array[i][j] == 0) continue;

                array[i][j] = Math.min(array[i - 1][j - 1],
                    Math.min(array[i - 1][j], array[i][j - 1])) + 1;

                result = Math.max(result, array[i][j]);
            }
        }

        System.out.println(result * result);
    }
}