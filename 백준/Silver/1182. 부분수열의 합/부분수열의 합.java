import java.io.*;
import java.util.*;

public class Main {
    static int result = 0;
    static int N, S;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        seq =  new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        rec(0, 0);

        // 크기가 양수인 부분수열만
        if (S == 0) result--;

        System.out.println(result);
    }

    private static void rec(int sum, int depth) {
        if (depth == N) {
            if (sum == S) {
                result++;
            }
            return;
        }

        // 현재 depth 포함 안 했을 때
        rec(sum, depth + 1);

        // 현재 depth 포함했을 때
        rec(sum + seq[depth], depth + 1);
    }
}