import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            // 현재 위치에서 사방위 이동가능여부 판별해주기
            for (int i = 0; i < 4; i++) {
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];

                // 1. 범위 이내에 있는가?
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;   // 범위에서 나가면 제끼기
                // 2. 막힌 길인가?
                if (maze[nextX][nextY] == 0)
                    continue;   // 막힌 길이면 제끼기
                // 3. 이미 방문 했나?
                if (visit[nextX][nextY])
                    continue;   // 방문했으면(true 이면) 제끼기
                // 모든 조건에 해당되지 않음. 즉, 갈 수 있는 길이면
                // queue 에 삽입해주고 방문처리.
                queue.offer(new Point(nextX, nextY));
                visit[nextX][nextY] = true;
                // 그리고 최소 칸의 수를 구해야되므로 해당하는 칸에 1씩 누적해서
                // 도착 칸이면 그 값이 지나야 하는 최소 칸의 수.
                maze[nextX][nextY] = maze[currentPoint.x][currentPoint.y] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(maze[N - 1][M - 1]);
    }
}
