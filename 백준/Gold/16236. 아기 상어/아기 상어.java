import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int sharkSize = 2;   // 아기 상어의 크기
    static int eaten = 0;   // 잡아먹은 물고기 수
    static int[][] field;   // 공간
    static int[] dx = { -1, 0, 0, 1 };
    static int[] dy = { 0, -1, 1, 0 };
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        field = new int[N][N];
        StringTokenizer st;
        int sharkX = 0;
        int sharkY = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if (field[i][j] == 9) { // 아기 상어 초기 위치 저장
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

        while (true) {
            // 거리가 가장 가까운 물고기 위치 구하기
            int[] fish = closest(sharkX, sharkY);
            if (fish[0] == -1 && fish[1] == -1) {
                System.out.println(time);
                return;
            }

            // 물고기 먹기
            field[sharkX][sharkY] = 0;  // 원래 상어 위치 0으로
            sharkX = fish[0];
            sharkY = fish[1];
            field[sharkX][sharkY] = 0;  // 물고기 먹은 곳 0으로
            eaten++;
            time += fish[2];

            // 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기 1 증가
            if (eaten == sharkSize) {
                sharkSize++;
                eaten = 0;
            }
        }
    }

    static int[] closest(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        visited[x][y] = true;
        q.add(new int[]{x, y, 0});  // index2는 거리

        List<int[]> candidates = new ArrayList<>();  // 같은 거리의 물고기 후보들
        int minDistance = Integer.MAX_VALUE;  // 최소 거리

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            int distance = curr[2];

            // 이미 더 가까운 물고기를 찾았다면, 더 이상 탐색 불필요
            if (distance > minDistance) {
                break;
            }

            // 해당 위치에 먹을 수 있는 물고기 존재
            if (field[cx][cy] > 0 && field[cx][cy] < sharkSize) {
                minDistance = distance;  // 최소 거리 갱신
                candidates.add(new int[]{cx, cy, distance});  // 후보에 추가
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && field[nx][ny] <= sharkSize) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, distance + 1});
                }
            }
        }

        // 먹을 수 있는 물고기가 없는 경우
        if (candidates.isEmpty()) {
            return new int[]{-1, -1};
        }

        // 같은 거리의 후보 중 우선순위가 가장 높은 물고기 선택 (위, 왼쪽)
        candidates.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        return candidates.get(0);
    }
}