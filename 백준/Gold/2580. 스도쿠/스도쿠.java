import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[9][9];

        StringTokenizer st;
        int zeroCount = 0;
        int num;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if (num == 0) {
                    zeroCount++;
                }
            }
        }

        if (sudoku(board, zeroCount)) {
            printBoard(board);
        }

    }

    static boolean sudoku(int[][] board, int termination) {
        if (termination == 0) {
            return true;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        board[i][j] = k;

                        if (promising(board, i, j)) {
                            if (sudoku(board, termination - 1)) {
                                return true;
                            }
                        }
                        board[i][j] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean promising(int[][] board, int x, int y) {
        int num = board[x][y]; // 검사할 숫자

        // 가로줄 검사
        for (int j = 0; j < 9; j++) {
            if (j != y && board[x][j] == num) return false;
        }

        // 세로줄 검사
        for (int i = 0; i < 9; i++) {
            if (i != x && board[i][y] == num) return false;
        }

        // 정사각형 검사
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (!(i == x && j == y) && board[i][j] == num) return false;
            }
        }

        return true;
    }

    static void printBoard(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}