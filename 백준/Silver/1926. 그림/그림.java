import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int area = 0;
    static int maxArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 도화지 색칠 표시
        paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 그림의 개수
        int total = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    total++;
                    area = 0;   // 해당 그림의 넓이
                    dfs(i, j);
                }
            }
        }

        System.out.println(total);
        System.out.println(maxArea);
    }

    static void dfs(int x, int y) {
        // 해당 부분 방문 처리
        visited[x][y] = true;
        area++;
        maxArea =  Math.max(area, maxArea);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && paper[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}