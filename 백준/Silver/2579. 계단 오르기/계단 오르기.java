import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n+1];

        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[][] step = new int[3][n+1];

        step[1][1] = score[1];
        if (n > 1) {
            step[1][2] = score[2];
            step[2][2] = step[1][1] + score[2];
        }
        for (int i = 3; i <= n; i++) {
            step[1][i] = Math.max(step[1][i-2], step[2][i-2]) + score[i];
            step[2][i] = step[1][i-1] + score[i];
        }
        System.out.println(Math.max(step[1][n], step[2][n]));

    }
}
