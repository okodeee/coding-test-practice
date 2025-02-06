import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        char c;
        boolean flag;
        for (int i = 0; i < M - 2 * N; i++) {
            flag = true;
            for (int n = 0; n < 2 * N + 1; n++) {
                c = (n % 2 == 0) ? 'I' : 'O';

                if (S.charAt(i + n) != c) {
                    flag = false;
                    n = 2 * N + 1;
                    break;
                }
            }

            if (flag) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}