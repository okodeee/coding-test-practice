import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(Integer.parseInt(br.readLine()));
            return;
        }

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int result = 0;
        int isNegative = 0;
        int isPositive = N - 1;

        // 음수 묶기
        int tied;
        while (isNegative < N - 1 && nums[isNegative] < 0 && (tied = nums[isNegative] * nums[isNegative + 1]) >= 0) {
            result += tied;
            isNegative += 2;
        }

        // 양수 묶기
        while (isPositive > 0 && nums[isPositive] > 1 && nums[isPositive - 1] > 1 && (tied = nums[isPositive] * nums[isPositive - 1]) > 1) {
            result += tied;
            isPositive -= 2;
        }

        // 못 묶인 수 더하기
        while (isNegative <= isPositive) {
            result += nums[isNegative];
            isNegative++;
        }

        System.out.println(result);
    }
}