import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N + 1];

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                rank[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int cnt = 1;    // 서류 1번은 무조건 합격;
            int value = rank[1];    // 뭘 비교해야 하는건지 정확하게 인지하기
            for (int i = 2; i <= N; i++) {
                if (value > rank[i]) {
                    cnt++;
                    value = rank[i];
                }
            }

            System.out.println(cnt);
        }
    }
}