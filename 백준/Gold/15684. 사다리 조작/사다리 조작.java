import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static boolean[][] ladder;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H + 1][N + 2]; // { a번 점선, b ~ b+1 세로선 } (1-based)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ladder[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        dfs(0);

        System.out.println((result > 3 ? -1 : result));
    }

    static void dfs(int depth) {
        // 유망한지 확인
        if (isValid()) {
            result = Math.min(result, depth);
        }

        if (depth == 3) return;

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                if (!ladder[i][j] && !ladder[i][j - 1] && !ladder[i][j + 1]) {
                    ladder[i][j] = true;
                    dfs(depth + 1);

                    // backtracking (해제)
                    ladder[i][j] = false;
                }
            }
        }
    }

    static boolean isValid() {
        for (int i = 1; i <= N; i++) {  // i번 세로선
            int curr = i;
            for (int j = 1; j <= H; j++) {
                if (ladder[j][curr]) {
                    curr++; // 오른쪽으로 이동
                } else if (ladder[j][curr - 1]) {
                    curr--; // 왼쪽으로 이동
                }
            }

            if (curr != i) {    // 처음 위치와 다르다면
                return false;
            }
        }

        return true;
    }
}