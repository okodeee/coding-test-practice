import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] board = new long[N + 1][N + 1];
        long[][] cases = new long[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cases[1][1] = 1;
        int move;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == N && j == N) break;
                move = (int)board[i][j];
                if (i + move <= N) {
                    cases[move + i][j] += cases[i][j];
//                    System.out.println((move + i) + " " + j + " " + cases[move + i][j]);
                }
                if (j + move <= N) {
                    cases[i][j + move] += cases[i][j];
//                    System.out.println(i + " " + (move + j) + " " + cases[i][move + j]);
                }
            }
        }

        System.out.println(cases[N][N]);
    }
}