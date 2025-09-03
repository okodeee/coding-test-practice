import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] plate;
    static boolean[][] air;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = {-1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        plate = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                plate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int T = 0;
        int count = 0;
        while(true) {
            if (countCheese() == 0) break;
            count = countCheese();

            getAir();

            melt();

            T++;
        }

        System.out.println(T);
        System.out.println(count);
    }

    static void getAir() {
        air = new boolean[R][C];
        boolean[][] visited = new boolean[R][C];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            air[curr[0]][curr[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && plate[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static void melt() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (plate[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && air[nx][ny]) {
                            plate[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

    static int countCheese() {
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (plate[i][j] == 1) count++;
            }
        }
        return count;
    }
}