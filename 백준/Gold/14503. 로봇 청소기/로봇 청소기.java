import java.io.*;
import java.util.*;


public class Main {
    static int count = 0;
    static int[][] rooms;
    static int N;
    static int M;
    static int r;
    static int c;
    static int d;

    // 북, 동, 남, 서쪽으로 가기
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        rooms = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            // 현재 칸 청소
            if (rooms[r][c] == 0) {
                clean(r, c);
            }

            boolean isClean = true;
            // 4방향 탐색
            int T = 4;
            while (T-- > 0) {
                d = (d + 3) % 4;  // 반시계 방향 회전

                int nextr = r + dx[d];
                int nextc = c + dy[d];

                if (rooms[nextr][nextc] == 0) {
                    r = nextr;
                    c = nextc;
                    isClean = false;
                    break;
                }
            }

            if (isClean) {
                // 청소되지 않은 빈 칸이 없는 경우 후진
                if (d == 0) {
                    r++;
                } else if (d == 1) {
                    c--;
                } else if (d == 2) {
                    r--;
                } else if (d == 3) {
                    c++;
                }

                if (rooms[r][c] == 1) {
                    break;
                }
            }
        }

        System.out.println(count);
    }

    static void clean(int x, int y) {
        rooms[x][y] = 2;
        count++;
//        System.out.println(x + " " + y + " " + d);
    }

    // Java에서 기본형 매개변수는 값이 복사되어 전달 -> 직접 d 조작
//    static void turn(int d) {
//        d--;
//        if (d == -1) d = 3;
//    }
}