import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static boolean[][] area;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int width = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M =  Integer.parseInt(st.nextToken());
        N =  Integer.parseInt(st.nextToken());
        K =  Integer.parseInt(st.nextToken());
        area = new boolean[N][M];
        visited = new boolean[N][M];

        // 직사각형 그리기
        int x1, y1, x2, y2;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    area[j][k] = true;
                }
            }
        }

        // 분리된 영역 개수 세기
        int cnt = 0;
        List<Integer> widthList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!area[i][j] && !visited[i][j]) {
                    cnt++;
                    dfs(i, j);
                    widthList.add(width);
                    width = 0;
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(widthList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < widthList.size(); i++) {
            sb.append(widthList.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        width++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !area[nx][ny] && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }

    }
}