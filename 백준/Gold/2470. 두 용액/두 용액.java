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

        // 2467 문제에서 정렬만 추가
        Arrays.sort(solution);

        // 투 포인터 탐색
        int left = 0, right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int result1 = 0, result2 = 0;

        while (left < right) {
            int sum = solution[left] + solution[right];

            // 최소값 갱신
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                result1 = solution[left];
                result2 = solution[right];

            }

            // 투 포인터 이동
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result1 + " " + result2);
    }
}