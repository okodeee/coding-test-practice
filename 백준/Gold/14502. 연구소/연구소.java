import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기 연구소 지도 입력 받기
        int[][] map =  new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽 세우기
        buildWall(0, map);

        System.out.println(result);
    }

    // 벽 세우기
    static void buildWall(int depth, int[][] map) {
        if (depth == 3) {
            result = Math.max(result, safeArea(map));
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(depth + 1, copyMap(map));
                    map[i][j] = 0;
                }
            }
        }
    }

    // 배열 깊은 복사 함수
    static int[][] copyMap(int[][] original) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;  // 새로운 주소 반환
    }

    // 안전 영역 크기 구하기
    static int safeArea(int[][] map) {
        // 바이러스 퍼뜨리기
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2 && !visited[i][j]) {
                    dfs(i, j, map, visited);
                }
            }
        }

        int zero = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) zero++;
            }
        }

        return zero;
    }

    static void dfs(int x, int y, int[][] map, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] != 1) {
                map[nx][ny] = 2;
                dfs(nx, ny, map, visited);
            }
        }
    }

    // 지도 출력하는 함수
    static void printMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}