import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;

        // 투 포인터 알고리즘 시작
        while (right < N) {
            sum += seq[right];

            while (sum >= S) {
                // 현재 구간 길이 계산 및 최솟값 갱신
                minLength = Math.min(minLength, right - left + 1);

                sum -= seq[left];
                left++;
            }

            right++;
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}