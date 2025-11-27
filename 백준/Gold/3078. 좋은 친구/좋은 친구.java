import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] scoreOrder = new int[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            scoreOrder[i] = str.length();
        }

        long answer = 0;
        int[] length = new int[21]; // 윈도우 내에 해당 길이 이름인 학생이 몇 명인지 저장
        for (int i = 0; i < K; i++) {
            length[scoreOrder[i]]++;
        }

        for (int i = 0; i < N - K; i++) {
            length[scoreOrder[i]]--;
            length[scoreOrder[i + K]]++;

            answer += length[scoreOrder[i]];
        }

        for (int i = 1; i < 21; i++) {  // 마지막 윈도우 내에서의 쌍 구하기
            while (length[i] > 1) {
                answer += length[i] - 1;
                length[i]--;
            }
        }

        System.out.println(answer);
    }
}