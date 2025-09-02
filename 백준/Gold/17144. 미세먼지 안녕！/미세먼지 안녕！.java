import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int air;
    static int[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // 방의 정보 입력
        room = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) air = i;
            }
        }

        while (T-- > 0) {
            spread();
            airCleaning();
        }

        System.out.println(getAmount());
    }

    static void spread() {
        int[][] nextRoom = new int[R][C];
        for (int i = 0; i < R; i++) {   // 배열 복사
            for (int j = 0; j < C; j++) {
                nextRoom[i][j] = room[i][j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] >= 5) {
                    int amount = room[i][j] / 5;
                    if (i - 1 >= 0 && room[i - 1][j] >= 0) {
                        nextRoom[i - 1][j] += amount;
                        nextRoom[i][j] -= amount;
                    }
                    if (i + 1 < R && room[i + 1][j] >= 0) {
                        nextRoom[i + 1][j] += amount;
                        nextRoom[i][j] -= amount;
                    }
                    if (j - 1 >= 0 && room[i][j - 1] >= 0) {
                        nextRoom[i][j - 1] += amount;
                        nextRoom[i][j] -= amount;
                    }
                    if (j + 1 < C && room[i][j + 1] >= 0) {
                        nextRoom[i][j + 1] += amount;
                        nextRoom[i][j] -= amount;
                    }
                }
            }
        }

        room = nextRoom;
    }

    static void airCleaning() {
        // 위쪽 바람
        for (int i = air - 3; i >= 0; i--) {
            room[i + 1][0] = room[i][0];
        }
        for (int j = 1; j < C; j++) {
            room[0][j - 1] = room[0][j];
        }
        for (int i = 1; i <= air - 1; i++) {
            room[i - 1][C - 1] = room[i][C - 1];
        }
        for (int j = C - 2; j > 0; j--) {
            room[air - 1][j + 1] = room[air - 1][j];
        }
        room[air - 1][1] = 0;

        // 아래쪽 바람
        for (int i = air + 2; i < R; i++) {
            room[i - 1][0] = room[i][0];
        }
        for (int j = 1; j < C; j++) {
            room[R - 1][j - 1] = room[R - 1][j];
        }
        for (int i = R - 2; i >= air; i--) {
            room[i + 1][C - 1] = room[i][C - 1];
        }
        for (int j = C - 2; j > 0; j--) {
            room[air][j + 1] = room[air][j];
        }
        room[air][1] = 0;
    }

    static int getAmount() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) sum += room[i][j];
            }
        }
        return sum;
    }

    static void printRoom() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(room[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}