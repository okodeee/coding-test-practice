import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] height;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        height = new int[N][N];
        visited = new boolean[N][N];

        // 높이 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 높이 값에 대한 안전 영역 개수 구하기
        int result = 0;
        for (int i = 0; i <= 100; i++) {
            result = Math.max(result, area(i));
        }

        System.out.println(result);
    }

    public static int area(int flood) {
        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (height[i][j] > flood && !visited[i][j]) {
                    // 연결된 지역 visited 처리
                    dfs(i, j, flood);
                    count++;
                }
            }
        }

        // visited 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }

        return count;
    }

    public static void dfs(int x, int y, int flood) {
        visited[x][y] = true;
        if (x - 1 >= 0 && height[x - 1][y] > flood && !visited[x - 1][y]) {
            dfs(x - 1, y, flood);
        }

        if (x + 1 < N  && height[x + 1][y] > flood && !visited[x + 1][y]) {
            dfs(x + 1, y, flood);
        }

        if (y - 1 >= 0  && height[x][y - 1] > flood && !visited[x][y - 1]) {
            dfs(x, y - 1, flood);
        }

        if (y + 1 < N  && height[x][y + 1] > flood && !visited[x][y + 1]) {
            dfs(x, y + 1, flood);
        }
    }
}