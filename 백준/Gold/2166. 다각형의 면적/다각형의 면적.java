import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] point = new int[N + 1][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        point[N][0] = point[0][0];
        point[N][1] = point[0][1];

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (double)point[i][0] * point[i + 1][1];
            sum -= (double)point[i + 1][0] * point[i][1];
        }

        System.out.printf("%.1f", Math.abs(sum) / 2.0);
    }
}