import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int rotate = 0; rotate < R; rotate++) {
            for (int i = 0; i < Math.min(N, M) / 2; i++) { // 회전 그룹
                int temp = array[i][i];

                // 윗줄을 왼쪽 방향으로
                for (int j = i + 1; j < M - i; j++) {
                    array[i][j - 1] = array[i][j];
                }

                // 오른줄을 윗 방향으로
                for (int j = i + 1; j < N - i; j++) {
                    array[j - 1][M - 1 - i] = array[j][M - 1 - i];
                }

                // 아랫줄을 오른쪽 방향으로
                for (int j = M - 2 - i; j >= i; j--) {
                    array[N - 1 - i][j + 1] = array[N - 1 - i][j];
                }

                // 왼줄을 아래 방향으로
                for (int j = N - 2 - i; j >= i; j--) {
                    array[j + 1][i] = array[j][i];
                }
                array[i + 1][i] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(array[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}