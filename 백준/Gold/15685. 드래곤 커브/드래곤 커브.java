import java.io.*;
import java.util.*;


public class Main {

    static boolean[][] field = new boolean[101][101];
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            makeDragonCurve(x, y, d, g);
        }

        System.out.println(countSquare());
    }

    // 방향 회전 공식
    static int getDirection(int dir) {
        return (dir + 1) % 4;  // 0 → 1 → 2 → 3 → 0
    }

    static void makeDragonCurve(int x, int y, int d, int g) {
        // 세대별 방향 패턴 만들기
        List<Integer> directions = new ArrayList<>();
        directions.add(d);  // 0세대

        for (int generation = 0; generation < g; generation++) {
            int size = directions.size();
            // 뒤에서부터 읽으면서 시계방향 90도 회전한 방향 추가
            for (int i = size - 1; i >= 0; i--) {
                directions.add(getDirection(directions.get(i)));
            }
        }

        // 방향 리스트대로 좌표 찍기
        field[x][y] = true;

        for (int dir : directions) {
            x += dx[dir];
            y += dy[dir];
            field[x][y] = true;
        }
    }

    static int countSquare() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (field[i][j] && field[i + 1][j] && field[i][j + 1] && field[i + 1][j + 1]) {
                    count++;
                }
            }
        }

        return count;
    }
}