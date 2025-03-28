import java.io.*;
import java.util.*;

/*
 * 토마토
 * 매 반복마다 Queue에서 꺼낸 위치에서 상하좌우 전파
 * 날짜는 이전 좌표의 날짜 + 1로 기록
 * BFS 종료 후, 모든 칸이 익었는지 확인, 날짜의 최댓값 구하기
 */
public class Main {
    static int H, N, M;
    static int[][][] tomatoes;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[H + 1][N + 1][M + 1];
        for (int h = 1; h <= H; h++) {
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; j++) {
                    tomatoes[h][i][j] = Integer.parseInt(st.nextToken());
                    if (tomatoes[h][i][j] == 1) {
                        queue.offer(new int[]{h, i, j});
                    }
                }
            }
        }

        bfs();

        int result = 0;
        for (int h = 1; h <= H; h++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (tomatoes[h][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, tomatoes[h][i][j]);
                }
            }
        }

        System.out.println(result - 1); // 처음부터 익은 토마토는 0일이기 때문
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int z = current[0], x = current[1], y = current[2];

            for (int i = 0; i < 6; i++) {
                int nextZ = z + dz[i];
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextZ > 0 && nextZ <= H && nextX > 0 && nextX <= N && nextY > 0 && nextY <= M && tomatoes[nextZ][nextX][nextY] == 0) {
                    tomatoes[nextZ][nextX][nextY] = tomatoes[z][x][y] + 1;
                    queue.offer(new int[]{nextZ, nextX, nextY});
                }
            }
        }
    }
}