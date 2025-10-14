import java.io.*;
import java.util.*;

public class Main {
    static int white = 0;   // 0은 흰색
    static int blue = 0;    // 1은 파란색
    static int[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        field = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    field[i][j] = 1;
                }
            }
        }

        split(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void split(int startR, int startC, int length) {
        // 하나의 정사각형 칸
        if (length == 1) {
            if (field[startR][startC] == 1) {
                blue++;
            } else {
                white++;
            }
            return; // 종료
        }

        // 모두 하얀색 또는 모두 파란색
        int color = field[startR][startC];
        boolean all = true;
        for (int i = startR; i < startR + length; i++) {
            for (int j = startC; j < startC + length; j++) {
                if (field[i][j] != color) {
                    all = false;
                    i = startR + length;
                    break;
                }
            }
        }

        if (all) {
            if (color == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        // 색종이 자르기
        int half = length / 2;
        split(startR, startC, half);
        split(startR, startC + half, half);
        split(startR + half, startC, half);
        split(startR + half, startC + half, half);
    }
}