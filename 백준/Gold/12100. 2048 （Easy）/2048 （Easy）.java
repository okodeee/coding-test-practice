import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 보드 초기화
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);

        System.out.println(result);
    }

    // 5번 이동
    static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            result = Math.max(result, maxNum(board));
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[][] newBoard = copyBoard(board);
            move(i, newBoard);
            dfs(depth + 1, newBoard);
        }
    }

    // 깊은 복사 함수
    static int[][] copyBoard(int[][] original) {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = original[i][j];  // 값 복사 (새로운 메모리)
            }
        }
        return copy;  // 새로운 주소 반환
    }

    // 이동시키는 함수
    static int[][] move(int direction, int[][] board) {
        // ↑
        if (direction == 0) {
            for (int j = 0; j < N; j++) {
                int fillIndex = 0;
                int prevNum = 1;
                for (int i = 0; i < N; i++) {
                    if (board[i][j] == 0)
                        continue;
                    else if (prevNum == board[i][j]) {
                        board[fillIndex - 1][j] = prevNum * 2;
                        board[i][j] = 0;
                        prevNum = 1;
                    } else {
                        board[fillIndex][j] = board[i][j];
                        prevNum = board[i][j];
                        if (fillIndex != i) {
                            board[i][j] = 0;
                        }
                        fillIndex++;
                    }
                }
            }
        }

        // →
        else if (direction == 1) {
            for (int i = 0; i < N; i++) {
                int fillIndex = N - 1;
                int prevNum = 1;
                for (int j = N - 1; j >= 0; j--) {
                    if (board[i][j] == 0)
                        continue;
                    else if (prevNum == board[i][j]) {
                        board[i][fillIndex + 1] = prevNum * 2;
                        board[i][j] = 0;
                        prevNum = 1;
                    } else {
                        board[i][fillIndex] = board[i][j];
                        prevNum = board[i][j];
                        if (fillIndex != j) {
                            board[i][j] = 0;
                        }
                        fillIndex--;
                    }
                }
            }
        }

        // ↓
        else if (direction == 2) {
            for (int j = 0; j < N; j++) {
                int fillIndex = N - 1;
                int prevNum = 1;
                for (int i = N - 1; i >= 0; i--) {
                    if (board[i][j] == 0)
                        continue;
                    else if (prevNum == board[i][j]) {
                        board[fillIndex + 1][j] = prevNum * 2;
                        board[i][j] = 0;
                        prevNum = 1;
                    } else {
                        board[fillIndex][j] = board[i][j];
                        prevNum = board[i][j];
                        if (fillIndex != i) {
                            board[i][j] = 0;
                        }
                        fillIndex--;
                    }
                }
            }
        }

        // ←
        else if (direction == 3) {
            for (int i = 0; i < N; i++) {
                int fillIndex = 0;
                int prevNum = 1;
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0)
                        continue;
                    else if (prevNum == board[i][j]) {
                        board[i][fillIndex - 1] = prevNum * 2;
                        board[i][j] = 0;
                        prevNum = 1;
                    } else {
                        board[i][fillIndex] = board[i][j];
                        prevNum = board[i][j];
                        if (fillIndex != j) {
                            board[i][j] = 0;
                        }
                        fillIndex++;
                    }
                }
            }
        }

        return board;
    }

    // 최댓값 구하는 함수
    static int maxNum(int[][] board) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        return max;
    }

    // 보드 출력하는 함수
    static void printBoard(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}