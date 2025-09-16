import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int target = nums[i];
            int left = 0;
            int right = N - 1;

            while (left < right) {
                // 자기 자신은 제외
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = nums[left] + nums[right];

                if (sum == target) {
                    count++;
                    break;  // 좋은 수 찾았으니 다음 수로
                } else if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                }
            }
        }

        System.out.println(count);
    }
}