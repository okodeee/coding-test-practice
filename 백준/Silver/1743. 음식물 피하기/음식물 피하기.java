import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static boolean[][] waste;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int mass;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 위치 1부터 사용
        waste = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        // 음식물 위치 저장
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            waste[r][c] = true;
        }

        // dfs로 가장 큰 음식물 덩어리 판별
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (waste[i][j] && !visited[i][j]) {
                    mass = 0;
                    dfs(i, j);
                    result = Math.max(result, mass);
                }
            }
        }

        System.out.println(result);
    }

    static void dfs(int r, int c) {
        mass++;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if (nx > 0 && nx <= N && ny > 0 && ny <= M && waste[nx][ny] && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}