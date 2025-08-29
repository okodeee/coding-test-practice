import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] ice; // 빙산의 높이
    static int[][] adj; // 인접한 바다 개수
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ice = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        if (countChunk() > 1) {
            System.out.println(result);
            return;
        }

        while (true) {
            result++;
            countAdj();
            melt();

            if (countChunk() > 1) {
                System.out.println(result);
                return;
            } else if (countChunk() == 0) {
                System.out.println(0);
                return;
            }

        }
    }

    static void countAdj() {
        adj = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ice[i][j] != 0) {
                    int count = 0;
                    if (i - 1 >= 0 && ice[i - 1][j] == 0) count++;
                    if (i + 1 < N && ice[i + 1][j] == 0) count++;
                    if (j - 1 >= 0 && ice[i][j - 1] == 0) count++;
                    if (j + 1 < M && ice[i][j + 1] == 0) count++;
                    adj[i][j] = count;
                }
            }
        }
    }

    static void melt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ice[i][j] = Math.max(ice[i][j] - adj[i][j], 0);
            }
        }
    }

    static int countChunk() {
        visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && ice[i][j] > 0) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        if (x - 1 >= 0 && !visited[x - 1][y] && ice[x - 1][y] > 0) dfs(x - 1, y);
        if (x + 1 < N && !visited[x + 1][y] && ice[x + 1][y] > 0) dfs(x + 1, y);
        if (y - 1 >= 0 && !visited[x][y - 1] && ice[x][y - 1] > 0) dfs(x, y - 1);
        if (y + 1 < M && !visited[x][y + 1] && ice[x][y + 1] > 0) dfs(x, y + 1);

    }
}