import java.io.*;
import java.util.*;

public class Main {
    // 주사위에 적힌 수
    //   2
    // 4 1 3  (주사위 전개도)
    //   5
    //   6
    static int[] dice = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int move = Integer.parseInt(st.nextToken());

            if (move == 1 && y + 1 < M) {   // 동

                // 주사위 굴리기
                rollEast();
                y++;
                
                // 숫자 복사
                if (map[x][y] == 0) {
                    map[x][y] = dice[5];
                } else {
                    dice[5] = map[x][y];
                    map[x][y] = 0;
                }

                sb.append(dice[0]).append('\n');

            } else if (move == 2 && y - 1 >= 0) { // 서

                rollWest();
                y--;

                if (map[x][y] == 0) {
                    map[x][y] = dice[5];
                } else {
                    dice[5] = map[x][y];
                    map[x][y] = 0;
                }

                sb.append(dice[0]).append('\n');

            } else if (move == 3 && x - 1 >= 0) { // 북

                rollNorth();
                x--;

                if (map[x][y] == 0) {
                    map[x][y] = dice[5];
                } else {
                    dice[5] = map[x][y];
                    map[x][y] = 0;
                }

                sb.append(dice[0]).append('\n');

            } else if (move == 4 && x + 1 < N) { // 남

                rollSouth();
                x++;

                if (map[x][y] == 0) {
                    map[x][y] = dice[5];
                } else {
                    dice[5] = map[x][y];
                    map[x][y] = 0;
                }

                sb.append(dice[0]).append('\n');
            }
        }

        System.out.println(sb);
    }

    static void rollEast() {
        int temp = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[5];
        dice[5] = dice[2];
        dice[2] = temp;
    }

    static void rollWest() {
        int temp = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[5];
        dice[5] = dice[3];
        dice[3] = temp;
    }

    static void rollNorth() {
        int temp = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[5];
        dice[5] = dice[1];
        dice[1] = temp;
    }

    static void rollSouth() {
        int temp = dice[0];
        dice[0] = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[4];
        dice[4] = temp;
    }
}