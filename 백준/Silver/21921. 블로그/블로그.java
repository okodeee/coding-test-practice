import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] visitors = new int[N];
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        int maxVisitors = 0;
        int periodNum = 1;

        for (int i = 0; i < X; i++) {
            maxVisitors += visitors[i];
        }

        int tempVisitors = maxVisitors;
        for (int i = 0; i < N - X; i++) {
            tempVisitors -= visitors[i];
            tempVisitors += visitors[i + X];

            if (tempVisitors > maxVisitors) {
                maxVisitors = tempVisitors;
                periodNum = 1;
            } else if (tempVisitors == maxVisitors) {
                periodNum++;
            }
        }

        if (maxVisitors == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(maxVisitors);
        System.out.println(periodNum);
    }
}
