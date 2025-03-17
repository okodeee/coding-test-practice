import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] packages = new int[M];
        int[] each = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            packages[i] = Integer.parseInt(st.nextToken());
            each[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(packages);
        Arrays.sort(each);

        int sum = 0;

        if (packages[0] >= each[0] * 6) {
            sum += N * each[0];
            System.out.println(sum);
            return;
        }

        if (N >= 6) {
            int num = N / 6;
            sum = num * packages[0];
            N -= num * 6;
        }
        sum += Math.min(N * each[0], packages[0]);

        System.out.println(sum);
    }
}
