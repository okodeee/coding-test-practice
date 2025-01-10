import java.io.*;
import java.util.*;

public class Main {
    static int N, K, result;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int total) {
        if (total > N) return; // n보다 크면 종료
        if (result < total) result = total; // 더 큰 값으로 ans 갱신

        for (int i = K - 1; i >= 0; i--) {
            dfs(total * 10 + arr[i]);
        }
    }
}