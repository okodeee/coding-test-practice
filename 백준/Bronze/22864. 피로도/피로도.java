import static java.lang.Math.max;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int fatigue = 0;
        int work = 0;

        for (int i = 0; i < 24; i++) {
            if (fatigue + A > M) {
                fatigue = max(0, fatigue - C);
                continue;
            }
            fatigue += A;
            work += B;
        }
        System.out.println(work);
    }
}