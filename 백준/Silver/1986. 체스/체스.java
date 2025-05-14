import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static int[] queenX = {0, 1, 0, -1, -1, 1, 1, -1};
    static int[] queenY = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] knightX = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] knightY = {1, 2, 2, 1, -1, -2, -2, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        List<int[]> pieceList = new ArrayList<>();

        // Queen
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for (int i = 0; i < num; i++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            board[x][y] = 1;
            pieceList.add(new int[]{x, y, 1});
        }

        // Knight
        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        for (int i = 0; i < num; i++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            board[x][y] = 2;
            pieceList.add(new int[]{x, y, 2});
        }

        // Pawn
        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        for (int i = 0; i < num; i++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            board[x][y] = 3;
//            pieceList.add(new int[]{x, y, 3});
        }

        // 말 이동
        for (int i = 0; i < pieceList.size(); i++) {
            int[] piece = pieceList.get(i);

            // Queen
            if (piece[2] == 1) {
                for (int k = 0; k < 8; k++) {
                    queen(piece[0], piece[1], k);
                }
            } else if (piece[2] == 2) { // Knight
                for (int k = 0; k < 8; k++) {
                    int nextX = piece[0] + knightX[k];
                    int nextY = piece[1] + knightY[k];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && (board[nextX][nextY] == 0 || board[nextX][nextY] == 4)) {
                        board[nextX][nextY] = 4;
                    }
                }
            }
        }

        // 안전한 칸 개수 구하기
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                System.out.print(board[i][j] + " ");
                if (board[i][j] == 0) count++;
            }
//            System.out.println();
        }
        System.out.println(count);
    }

    public static void queen(int x, int y, int num) {
        int nextX = x + queenX[num];
        int nextY = y + queenY[num];

        if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && (board[nextX][nextY] == 0 || board[nextX][nextY] == 4)) {
            board[nextX][nextY] = 4;
            queen(nextX, nextY, num);
        }
    }
}