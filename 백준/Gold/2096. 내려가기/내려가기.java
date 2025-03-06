import java.io.*;
import java.util.*;

public class Main {
    static int[][] score;
    static int[][] maxScore;
    static int[][] minScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        score = new int[N + 1][4];
        maxScore = new int[N + 1][4];
        minScore = new int[N + 1][4];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 4; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxScore[1][1] = score[1][1];
        maxScore[1][2] = score[1][2];
        maxScore[1][3] = score[1][3];
        for (int i = 2; i <= N; i++) {
            if (maxScore[i-1][1] >= maxScore[i-1][2]) {
                maxScore[i][1] = maxScore[i-1][1] + score[i][1];
            } else {
                maxScore[i][1] = maxScore[i-1][2] + score[i][1];
            }

            if (maxScore[i-1][1] >= maxScore[i-1][2] && maxScore[i-1][1] >= maxScore[i-1][3]) {
                maxScore[i][2] = maxScore[i-1][1] + score[i][2];
            } else if (maxScore[i-1][2] >= maxScore[i-1][1] && maxScore[i-1][2] >= maxScore[i-1][3]) {
                maxScore[i][2] = maxScore[i-1][2] + score[i][2];
            } else {
                maxScore[i][2] = maxScore[i-1][3] + score[i][2];
            }

            if (maxScore[i-1][3] >= maxScore[i-1][2]) {
                maxScore[i][3] = maxScore[i-1][3] + score[i][3];
            } else {
                maxScore[i][3] = maxScore[i-1][2] + score[i][3];
            }
        }

        minScore[1][1] = score[1][1];
        minScore[1][2] = score[1][2];
        minScore[1][3] = score[1][3];
        for (int i = 2; i <= N; i++) {
            if (minScore[i-1][1] <= minScore[i-1][2]) {
                minScore[i][1] = minScore[i-1][1] + score[i][1];
            } else {
                minScore[i][1] = minScore[i-1][2] + score[i][1];
            }

            if (minScore[i-1][1] <= minScore[i-1][2] && minScore[i-1][1] <= minScore[i-1][3]) {
                minScore[i][2] = minScore[i-1][1] + score[i][2];
            } else if (minScore[i-1][2] <= minScore[i-1][1] && minScore[i-1][2] <= minScore[i-1][3]) {
                minScore[i][2] = minScore[i-1][2] + score[i][2];
            } else {
                minScore[i][2] = minScore[i-1][3] + score[i][2];
            }

            if (minScore[i-1][3] <= minScore[i-1][2]) {
                minScore[i][3] = minScore[i-1][3] + score[i][3];
            } else {
                minScore[i][3] = minScore[i-1][2] + score[i][3];
            }
        }

        int maxResult = Math.max(Math.max(maxScore[N][1], maxScore[N][2]), maxScore[N][3]);
        int minResult = Math.min(Math.min(minScore[N][1], minScore[N][2]), minScore[N][3]);
        System.out.println(maxResult + " " + minResult);
    }
}
