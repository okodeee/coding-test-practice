import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] solution = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);

        int result1 = 0; int result2 = 0; int result3 = 0;
        long answer = 3000000000L;
        for (int i = 0; i < N - 2; i++) {   // 하나를 고정시켜놓고 두 용액의 혼합과 계산
            int first = solution[i];
            int second = i + 1;  // 이미 선택한 것보다 큰 것만 보면 됨
            int third = N - 1;

            while (second < third) {
                long sum = (long)first + solution[second] + solution[third];

                if (Math.abs(sum) < answer) {
                    answer = Math.abs(sum);
                    result1 = first;
                    result2 = solution[second];
                    result3 = solution[third];
                }

                if (sum < 0) {
                    second++;
                } else if (sum > 0) {
                    third--;
                } else {
                    System.out.println(first + " " + solution[second] + " " + solution[third]);
                    return;
                }

            }
        }

        System.out.println(result1 + " " + result2 + " " + result3);
    }
}