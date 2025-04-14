import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] soldier;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int white, blue;
    static int whitePower, bluePower;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 병사 위치 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        soldier = new char[M][N];
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                soldier[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[M][N];
        // dfs로 뭉쳐있는 우리 병사 판별
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && soldier[i][j] == 'W') {
                    white = 0;
                    dfsWhite(i, j, white);
                    whitePower += white * white;
                }
            }
        }

        // dfs로 뭉쳐있는 상대 병사 판별
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && soldier[i][j] == 'B') {
                    blue = 0;
                    dfsBlue(i, j, blue);
                    bluePower += blue * blue;
                }
            }
        }

        // 출력
        System.out.println(whitePower + " " + bluePower);
    }

    static void dfsWhite(int x, int y, int depth) {
        visited[x][y] = true;
        white++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && soldier[nx][ny] == 'W') {
                dfsWhite(nx, ny, depth + 1);
            }
        }
    }

    static void dfsBlue(int x, int y, int depth) {
        visited[x][y] = true;
        blue++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && soldier[nx][ny] == 'B') {
                dfsBlue(nx, ny, depth + 1);
            }
        }
    }
}