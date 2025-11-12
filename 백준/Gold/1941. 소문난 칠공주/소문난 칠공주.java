import java.io.*;
import java.util.*;

public class Main {
    static int[][] field = new int[5][5];
    static boolean[] selected = new boolean[25];
    static int answer = 0;
    static int[] dx = new int[] { 0, 0, 1, -1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                field[i][j] = str.charAt(j);
            }
        }

        combination(0, 0);

        System.out.println(answer);
    }

    static void combination(int start, int count) {
        if (count == 7) {
            if (isValid() && isConnected()) {
                answer++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            selected[i] = true;
            combination(i + 1, count + 1);
            selected[i] = false;
        }
    }

    // S가 4 이상인지 확인
    static boolean isValid() {
        int sCount = 0;
        for (int i = 0; i < 25; i++) {
            if (selected[i]) {
                int x = i / 5;
                int y = i % 5;
                if (field[x][y] == 'S') {
                    sCount++;
                }
            }
        }
        return sCount >= 4;
    }

    // 선택된 7개 칸이 모두 연결되어 있는지 확인
    static boolean isConnected() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[25];
        int count = 0;

        for (int i = 0; i < 25; i++) {
            if (selected[i]) {
                queue.offer(i);
                visited[i] = true;
                count++;
                break;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / 5;
            int y = cur % 5;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int next = nx * 5 + ny;

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && selected[next] && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }

        return count == 7;
    }
}