import java.io.*;
import java.util.*;

public class Main {
    static char[][] field;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static List<int[]> group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                field[i][j] = str.charAt(j);
            }
        }

        int chain = 0;  // 연쇄횟수

        while(true) {
            boolean[][] visited = new boolean[12][6];
            boolean hasPopped = false;  // 터진 뿌요가 있는지 확인

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!visited[i][j] && field[i][j] != '.') {
                        char color = field[i][j];
                        group = new ArrayList<>();

                        dfs(i, j, color, visited);

                        if (group.size() >= 4) {
                            for (int[] pos : group) {
                                field[pos[0]][pos[1]] = '.';
                            }
                            hasPopped = true;
                        }
                    }
                }
            }

            if (!hasPopped) break;  // 더 이상 터질 뿌요가 없으면 종료

            chain++;

            fall(); // 뿌요 내리기

//            printField();
        }

        System.out.println(chain);
    }

    static void dfs(int x, int y, char color, boolean[][] visited) {
        visited[x][y] = true;
        group.add(new int[] {x, y});

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && field[nx][ny] == color && !visited[nx][ny]) {
                dfs(nx, ny, color, visited);
            }
        }
    }

    static void fall() {
        for (int j = 0; j < 6; j++) {
            int index = 11;
            for (int i = 11; i >= 0; i--) {
                if (field[i][j] != '.') {   // 채워져 있으면
                    if (index != i) {
                        field[index][j] = field[i][j];
                        field[i][j] = '.';
                    }
                    index--;
                }
            }
        }
    }

    static void printField() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                sb.append(field[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}