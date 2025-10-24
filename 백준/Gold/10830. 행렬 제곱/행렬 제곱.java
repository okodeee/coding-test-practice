import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = power(A, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int[][] power(int[][] matrix, long exp) {
        if (exp == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] %= 1000;
                }
            }

            return matrix;
        }

        int[][] half = power(matrix, exp / 2);

        int[][] result = multiply(half, half);

        if (exp % 2 != 0) {
            result = multiply(result, matrix);
        }

        return result;
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] newMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    newMatrix[i][j] += a[i][k] * b[k][j];
                    newMatrix[i][j] %= 1000;
                }
            }
        }

        return newMatrix;
    }
}