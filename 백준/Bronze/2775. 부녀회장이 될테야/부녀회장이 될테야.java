import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] apt = new int[k+1][n+1];

            for (int j = 1; j <= n; j++) {
                apt[0][j] = j;
            }
            for (int j = 1; j <= k; j++) {
                apt[j][1] = 1;
            }

            for (int x = 1; x <= k; x++) {
                for (int y = 2; y <= n; y++) {
                    apt[x][y] = apt[x][y-1] + apt[x-1][y];
                }
            }

            System.out.println(apt[k][n]);
        }
    }
}
