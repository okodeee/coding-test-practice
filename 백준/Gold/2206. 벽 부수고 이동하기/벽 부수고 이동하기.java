import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] field;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                field[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        int[][][] dist = new int[N][M][2];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0, 0});
        dist[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int destroyed = curr[2];

            // (N, M) 도착
            if (r == N - 1 && c == M - 1) {
                return dist[r][c][destroyed];
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nextR = r + dx[i];
                int nextC = c + dy[i];

                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
                    continue;
                }

                if (field[nextR][nextC] == 0 && dist[nextR][nextC][destroyed] == 0) {
                    dist[nextR][nextC][destroyed] = dist[r][c][destroyed] + 1;
                    queue.offer(new int[]{nextR, nextC, destroyed});
                } else if (field[nextR][nextC] == 1 && destroyed == 0 && dist[nextR][nextC][1] == 0) {    // 벽 부수기
                    dist[nextR][nextC][1] = dist[r][c][destroyed] + 1;
                    queue.offer(new int[]{nextR, nextC, 1});
                }
            }
        }

        return -1;
    }
}