import java.io.*;
import java.util.*;


public class Main {
    static int[][] rotationOperation;
    static int N, M, K;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotationOperation = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rotationOperation[i][0] = Integer.parseInt(st.nextToken()) - 1;
            rotationOperation[i][1] = Integer.parseInt(st.nextToken()) - 1;
            rotationOperation[i][2] = Integer.parseInt(st.nextToken());
        }

        // 회전 연산을 백트래킹
        boolean[] visited = new boolean[K];
        backtracking(0, visited, array);

        System.out.println(result);
    }

    static void backtracking(int depth, boolean[] visited, int[][] array) {
        if (depth == K) {
            result = Math.min(result, minimumValue(array));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {  // i번째 연산 실행
                boolean[] newVisited = new boolean[K];
                for (int j = 0; j < K; j++) {
                    newVisited[j] = visited[j];
                }
                newVisited[i] = true;

                backtracking(depth + 1, newVisited, doOperation(i, array));
            }
        }
    }

    static int[][] doOperation(int num, int[][] array) {
        int[][] newArray = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArray[i][j] = array[i][j];
            }
        }

        int r = rotationOperation[num][0];
        int c = rotationOperation[num][1];
        int s = rotationOperation[num][2];

        for (int i = 1; i <= s; i++) {  // s
            // 왼쪽 줄 이동 (↑)
            for (int j = r - i + 1; j <= r + i; j++) {
                newArray[j - 1][c - i] = array[j][c - i];
            }
            // 아래 줄 이동 (←)
            for (int j = c - i + 1; j <= c + i; j++) {
                newArray[r + i][j - 1] = array[r + i][j];
            }
            // 오른쪽 줄 이동 (↓)
            for (int j = r + i - 1; j >= r - i; j--) {
                newArray[j + 1][c + i] = array[j][c + i];
            }
            // 윗 줄 이동 (→)
            for (int j = c + i - 1; j >= c - i; j--) {
                newArray[r - i][j + 1] = array[r - i][j];
            }
        }
//        printArray(newArray);

        return newArray;
    }

    static int minimumValue(int[][] array) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += array[i][j];
            }
            result = Math.min(sum, result);
        }
        return result;
    }

    static void printArray(int[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(array[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}