import java.io.*;
import java.util.*;

public class Main {
    static int s, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int R1 = Integer.parseInt(st.nextToken());
        int R2 = Integer.parseInt(st.nextToken());
        int C1 = Integer.parseInt(st.nextToken());
        int C2 = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) {
                if (isBlack(i, j)) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static boolean isBlack(int x, int y) {
        // s번 반복하며 각 단계에서 가운데인지 확인
        for (int time = 0; time < s; time++) {
            int length = (int) Math.pow(N, s - time - 1);   // 한 칸의 크기

            // N*N 중 어느 칸에 속하는지 계산
            int R = x / length;
            int C = y / length;

            // 가운데 K*K 영역의 범위
            int blackStart = (N - K) / 2;
            int blackEnd = blackStart + K;

            if (R >= blackStart && R < blackEnd && C >= blackStart && C < blackEnd) {
                return true;
            }

            // 현재 칸 내에서의 상대 좌표
            x %= length;
            y %= length;
        }

        return false;
    }
}