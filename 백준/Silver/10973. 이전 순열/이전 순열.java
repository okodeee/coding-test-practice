import java.io.*;
import java.util.StringTokenizer;

/*
 * 1. 뒤에서부터 첫 증가 지점 찾기
 * 2. i 위치의 값과 교체할 값 찾기
 * 3. 값 교체
 * 4. i 이후의 순열 정리
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 이전 순열 계산
        if (prevPermutation(nums)) {
            // 결과 출력
            for (int num : nums) {
                System.out.print(num + " ");
            }
        } else {
            // 이전 순열이 없는 경우
            System.out.println("-1");
        }
    }

    // 다음 순열을 구하는 함수
    public static boolean prevPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: 뒤에서부터 첫 번째 증가 지점 찾기
        int i = n - 2;
        while (i >= 0 && nums[i] <= nums[i + 1]) {
            i--;
        }

        // 증가 지점을 못 찾은 경우 (첫번째 순열)
        if (i < 0) {
            return false;
        }

        // Step 2: i 이후에서 교체할 값 찾기
        int j = n - 1;
        while (nums[j] >= nums[i]) {
            j--;
        }

        // Step 3: 값 교환
        swap(nums, i, j);

        // Step 4: i 이후의 배열 정렬 (역순으로 뒤집기)
        reverse(nums, i + 1, n - 1);

        return true;
    }

    // 두 값을 교환하는 함수
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 배열을 뒤집는 함수
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}