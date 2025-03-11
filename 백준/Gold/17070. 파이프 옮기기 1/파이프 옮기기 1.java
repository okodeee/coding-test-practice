import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] pipe = new int[N + 1][N + 1][3];
        pipe[1][2][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                if (house[i][j] == 1)
                    continue;

                pipe[i][j][0] += pipe[i][j-1][0];
                pipe[i][j][0] += pipe[i][j-1][2];

                pipe[i][j][1] += pipe[i-1][j][1];
                pipe[i][j][1] += pipe[i-1][j][2];

                if (house[i-1][j] == 1 || house[i][j-1] == 1)
                    continue;
                pipe[i][j][2] += pipe[i-1][j-1][0];
                pipe[i][j][2] += pipe[i-1][j-1][1];
                pipe[i][j][2] += pipe[i-1][j-1][2];
            }
        }
        System.out.println(pipe[N][N][0] + pipe[N][N][1] + pipe[N][N][2]);
    }
}
