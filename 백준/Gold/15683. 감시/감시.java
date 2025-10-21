import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]> cctv = new ArrayList<>();
    static int[][] field;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if (field[i][j] >= 1 && field[i][j] <= 5) {
                    cctv.add(new int[] {i, j, 0});  // x좌표, y좌표, 방향
                }
            }
        }

        answer = N * M;
        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == cctv.size()) {
            // 사각지대 계산
            answer = Math.min(answer, countBlind(makeField()));

            return;
        }

        // CCTV 방향 설정
        for (int i = 0; i < 4; i++) {
            cctv.get(depth)[2] = i;

            dfs(depth + 1);
        }

    }

    static int[][] makeField() {
        int[][] newField = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newField[i][j] = field[i][j];
            }
        }

        for (int i = 0; i < cctv.size(); i++) {
            int[] curr = cctv.get(i);
            int x = curr[0];
            int y = curr[1];
            int s = field[x][y];    // CCTV 종류
            int d = curr[2];

            if (s == 1) {
                if (d == 0) {   // 동
                    cctvEast(x, y, newField);
                } else if (d == 1) {   // 서
                    cctvWest(x, y, newField);
                } else if (d == 2) {   // 남
                    cctvSouth(x, y, newField);
                } else if (d == 3) {   // 북
                    cctvNorth(x, y, newField);
                }

            } else if (s == 2) {
                if (d == 0 || d == 2) { // 가로
                    // 동쪽
                    cctvEast(x, y, newField);
                    //서쪽
                    cctvWest(x, y, newField);

                } else if (d == 1 || d == 3) {  // 세로
                    // 남쪽
                    cctvSouth(x, y, newField);
                    // 북쪽
                    cctvNorth(x, y, newField);
                }
            } else if (s == 3) {
                if (d == 0) {   // 북 & 동
                    cctvNorth(x, y, newField);
                    cctvEast(x, y, newField);
                } else if (d == 1) {    // 동 & 남
                    cctvEast(x, y, newField);
                    cctvSouth(x, y, newField);
                } else if (d == 2) {    // 남 & 서
                    cctvSouth(x, y, newField);
                    cctvWest(x, y, newField);
                } else if (d == 3) {    // 서 & 북
                    cctvWest(x, y, newField);
                    cctvNorth(x, y, newField);
                }
            } else if (s == 4) {
                if (d == 0) {   // 남 제외
                    cctvNorth(x, y, newField);
                    cctvEast(x, y, newField);
                    cctvWest(x, y, newField);
                } else if (d == 1) {    // 서 제외
                    cctvEast(x, y, newField);
                    cctvSouth(x, y, newField);
                    cctvNorth(x, y, newField);
                } else if (d == 2) {    // 북 제외
                    cctvEast(x, y, newField);
                    cctvWest(x, y, newField);
                    cctvSouth(x, y, newField);
                } else if (d == 3) {    // 동 제외
                    cctvSouth(x, y, newField);
                    cctvNorth(x, y, newField);
                    cctvWest(x, y, newField);
                }
            } else if (s == 5) {
                cctvNorth(x, y, newField);
                cctvEast(x, y, newField);
                cctvWest(x, y, newField);
                cctvSouth(x, y, newField);
            }
        }

        return newField;
    }

    static void cctvNorth(int x, int y, int[][] newField) {
        int nx = x - 1;
        while (nx >= 0 && field[nx][y] != 6) {  // 벽이 아닐 때까지
            if (field[nx][y] == 0) {
                newField[nx][y] = 9;    // 감시 범위
            }
            nx--;
        }
    }

    static void cctvSouth(int x, int y, int[][] newField) {
        int nx = x + 1;
        while (nx < N && field[nx][y] != 6) {  // 벽이 아닐 때까지
            if (field[nx][y] == 0) {
                newField[nx][y] = 9;    // 감시 범위
            }
            nx++;
        }
    }

    static void cctvEast(int x, int y, int[][] newField) {
        int ny = y + 1;
        while (ny < M && field[x][ny] != 6) {  // 벽이 아닐 때까지
            if (field[x][ny] == 0) {
                newField[x][ny] = 9;    // 감시 범위
            }
            ny++;
        }
    }

    static void cctvWest(int x, int y, int[][] newField) {
        int ny = y - 1;
        while (ny >= 0 && field[x][ny] != 6) {  // 벽이 아닐 때까지
            if (field[x][ny] == 0) {
                newField[x][ny] = 9;    // 감시 범위
            }
            ny--;
        }
    }

    static int countBlind(int[][] newField) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newField[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    static void printField(int[][] newField) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(newField[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}