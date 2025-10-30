import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] cheese;
    static int remain = 0;  // 남은 치즈 부분
    static int time = -1;    // 모두 녹는 데 걸린 시간
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    cheese[i][j] = true;
                    remain++;
                }
            }
        }

        while (++time >= 0)  {
            // 치즈가 모두 녹았나?
            if (remain == 0) {
                System.out.println(time);
                return;
            }

            // 외부 공기 위치
            boolean[][] air = getAir();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append(air[i][j]).append(' ');
                }
                sb.append('\n');
            }

            // 외부와 2변 이상 접촉한 치즈 녹기
            meltCheese(air);
        }
    }

    // 외부 공기 위치 구하기
    static boolean[][] getAir() {
        boolean[][] air = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        air[0][0] = true;
        q.add(new int[] { 0, 0 });

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !cheese[nx][ny] && !air[nx][ny]) {
                    air[nx][ny] = true;
                    q.add(new int[] { nx, ny });
                }
            }
        }

        return air;
    }

    // 외부와 2변 이상 접촉한 치즈 녹기
    static void meltCheese(boolean[][] air) {
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (cheese[i][j]) {
                    int meetAir = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (air[nx][ny]) {
                            meetAir++;
                        }
                    }

                    if (meetAir >= 2) {
                        remain--;
                        cheese[i][j] = false;
                    }
                }
            }
        }
    }

}