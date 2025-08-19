import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] water;
    static boolean[][] visited;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        water =  new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                water[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구름 위치 초기값
        List<int[]> cloud = new ArrayList<>();
        cloud.add(new int[]{N, 1});
        cloud.add(new int[]{N, 2});
        cloud.add(new int[]{N - 1, 1});
        cloud.add(new int[]{N - 1, 2});

        // 구름 이동 명령
        for (int i = 0; i < M; i++) {
            visited = new boolean[N + 1][N + 1];
            st = new StringTokenizer(br.readLine());
            int d =  Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            List<int[]> rainPositions = new ArrayList<>();

            // 모든 구름에 대해
            for (int j = 0; j < cloud.size(); j++) {
                // 1. di 방향으로 si칸 이동, 원형 격자
                int nx = ((cloud.get(j)[0] + dx[d - 1] * s - 1) % N + N) % N + 1;
                int ny = ((cloud.get(j)[1] + dy[d - 1] * s - 1) % N + N) % N + 1;

                // 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가
                water[nx][ny]++;

                // 3. (구름이 모두 사라진다: 방문 표시)
                visited[nx][ny] = true;

                // 비 내린 위치 기록
                rainPositions.add(new int[]{nx, ny});
            }

            // 4. 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전
            for (int j = 0; j < rainPositions.size(); j++) {
                waterCopyBug(rainPositions.get(j)[0], rainPositions.get(j)[1]);
            }

            // 3. 구름이 모두 사라짐
            cloud.clear();

            // 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다
            for (int x = 1; x <= N; x++) {
                for (int y = 1;  y <= N; y++) {
                    if (water[x][y] >= 2 && !visited[x][y]) {   // 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 함
                        cloud.add(new int[]{x, y});
                        water[x][y] -= 2;
                    }
                }
            }
        }

        // 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합
        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += water[i][j];
            }
        }

        System.out.println(result);
    }

    // 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼
    // (r, c)에 있는 바구니의 물이 양이 증가
    static void waterCopyBug(int r, int c) {
        int cnt = 0;
        if (r+1 <= N && c+1 <= N && water[r+1][c+1] > 0) cnt++;
        if (r-1 > 0 && c-1 > 0 && water[r-1][c-1] > 0) cnt++;
        if (r-1 > 0 && c+1 <= N && water[r-1][c+1] > 0) cnt++;
        if (r+1 <= N && c-1 > 0 && water[r+1][c-1] > 0) cnt++;

        water[r][c] += cnt;
    }
}