import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int[][] table;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색 (dfs)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, table[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int sum, int cnt) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if (!visited[nextX][nextY]) {
                    if (cnt == 2) {
                        visited[nextX][nextY] = true;
                        // 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한 번 더 진행
                        dfs(x, y, sum + table[nextX][nextY], cnt + 1);
                        visited[nextX][nextY] = false;
                    }
                    visited[nextX][nextY] = true;
                    dfs(nextX, nextY, sum + table[nextX][nextY], cnt + 1);
                    visited[nextX][nextY] = false;
                }
            }

        }
    }
}