import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[] dx = { 0, 0, -1, 1 };  // 왼, 오, 위, 아래
    static int[] dy = { -1, 1, 0, 0 };
    static char[][] field;
    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new char[N][M];
        int[] R = new int[] { 0, 0 };   // 구슬 위치 저장
        int[] B = new int[] { 0, 0 };
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'R') {
                    R[0] = i;
                    R[1] = j;
                }

                if (str.charAt(j) == 'B') {
                    B[0] = i;
                    B[1] = j;
                }
                field[i][j] = str.charAt(j);

            }
        }

        backtracking(1, R[0], R[1], B[0], B[1]);

        System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);
    }

    static void backtracking(int depth, int Rx, int Ry, int Bx, int By) {
        if (depth > 10) {
            return;
        }

        // 상하좌우 기울이기
        for (int i = 0; i < 4; i++) {
            // 빨간 구슬을 해당 방향으로 끝까지 굴리기
            int nRx = Rx;
            int nRy = Ry;
            boolean redHole = false;

            while (true) {
                int nextRx = nRx + dx[i];
                int nextRy = nRy + dy[i];

                // 범위를 벗어나거나 벽 만나면 멈춤
                if (nextRx < 0 || nextRx >= N || nextRy < 0 || nextRy >= M || field[nextRx][nextRy] == '#') {
                    break;
                }

                // 구멍 빠져나옴
                if (field[nextRx][nextRy] == 'O') {
                    nRx = nextRx;
                    nRy = nextRy;
                    redHole = true;
                    break;
                }

                // 빈 칸이면 계속 이동
                nRx = nextRx;
                nRy = nextRy;
            }

            // 파란 구슬을 해당 방향으로 끝까지 굴리기
            int nBx = Bx;
            int nBy = By;
            boolean blueHole = false;

            while (true) {
                int nextBx = nBx + dx[i];
                int nextBy = nBy + dy[i];

                // 범위를 벗어나거나 벽 만나면 멈춤
                if (nextBx < 0 || nextBx >= N || nextBy < 0 || nextBy >= M || field[nextBx][nextBy] == '#') {
                    break;
                }

                // 구멍 빠져나옴
                if (field[nextBx][nextBy] == 'O') {
                    nBx = nextBx;
                    nBy = nextBy;
                    blueHole = true;
                    break;
                }

                // 빈 칸이면 계속 이동
                nBx = nextBx;
                nBy = nextBy;
            }

            // 파란 구슬 빠져나옴(실패)
            if (blueHole) {
                continue;   // 이 방향은 실패, 다음 방향으로
            }

            // 빨간 구슬만 빠져나옴
            if (redHole) {
                minCount = Math.min(minCount, depth);
                continue;   // 더 좋은 경로가 있을 수 있음
            }

            // 두 구슬이 같은 위치에 있을 때
            if (nRx == nBx && nRy == nBy) {
                int redDist = Math.abs(nRx - Rx) + Math.abs(nRy - Ry);
                int blueDist = Math.abs(nBx - Bx) + Math.abs(nBy - By);

                // 더 많이 움직인 구슬을 한 칸 뒤로
                if (redDist > blueDist) {
                    nRx -= dx[i];
                    nRy -= dy[i];
                } else {
                    nBx -= dx[i];
                    nBy -= dy[i];
                }
            }

            // 위치가 변하지 않았으면 다음 방향으로
            if (Rx == nRx && Ry == nRy && Bx == nBx && By == nBy) {
                continue;
            }

            // 다음 기울이기 진행
            backtracking(depth + 1, nRx, nRy, nBx, nBy);
        }
    }
}