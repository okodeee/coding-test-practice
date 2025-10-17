import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };
    static char[][] board;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        boolean[] alpha = new boolean[26];
        boolean[][] visited = new boolean[R][C];
        alpha[board[0][0] - 'A'] = true;
        visited[0][0] = true;
        dfs(0, 0, 1, alpha, visited);

        System.out.println(answer);
    }

    static void dfs(int r, int c, int length, boolean[] alpha, boolean[][] visited) {
        answer = Math.max(answer, length);

        for (int i = 0; i < 4; i++) {
            int nextR = r + dx[i];
            int nextC = c + dy[i];

            if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || visited[nextR][nextC]) continue;

            // 알파벳 중복되면 중단
            if (alpha[board[nextR][nextC] - 'A']) continue;

            // 해당 칸으로 진행
            alpha[board[nextR][nextC] - 'A'] = true;
            visited[nextR][nextC] = true;
            dfs(nextR, nextC, length + 1, alpha, visited);

            alpha[board[nextR][nextC] - 'A'] = false;
            visited[nextR][nextC] = false;
        }
    }
}