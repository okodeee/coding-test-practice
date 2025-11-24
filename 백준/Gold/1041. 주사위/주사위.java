import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            Arrays.sort(nums);
            System.out.println(nums[0] + nums[1] + nums[2] + nums[3] + nums[4]);
            return;
        }

        int three = smallestThree(nums);
        int two = smallestTwo(nums);

        // int 범위 초과 → long
        long totalBlock = 5L * N * N - 8L * N + 4;
        long answer = 0;

        // 꼭짓점 블럭 개수 4개 고정
        answer += 4L * three;
        totalBlock -= 4;

        // 모서리 블럭 개수 구하기 (꼭짓점 블럭 제외)
        long corner = 8L * N - 12;
        answer += corner * two;
        totalBlock -= corner;

        // 나머지 블럭
        Arrays.sort(nums);
        answer += totalBlock * nums[0];

        System.out.println(answer);

    }

    private static int smallestThree(int[] nums) {
        List<Integer> three = new ArrayList<>();

        three.add(nums[0] + nums[1] + nums[2]); // A + B + C
        three.add(nums[0] + nums[1] + nums[3]); // A + B + D
        three.add(nums[0] + nums[2] + nums[4]); // A + C + E
        three.add(nums[0] + nums[3] + nums[4]); // A + D + E
        three.add(nums[1] + nums[2] + nums[5]); // B + C + F
        three.add(nums[1] + nums[3] + nums[5]); // B + D + F
        three.add(nums[2] + nums[4] + nums[5]); // C + E + F
        three.add(nums[3] + nums[4] + nums[5]); // D + E + F

        Collections.sort(three);

        return three.get(0);
    }

    private static int smallestTwo(int[] nums) {
        List<Integer> two = new ArrayList<>();

        two.add(nums[0] + nums[1]); // A + B
        two.add(nums[0] + nums[2]); // A + C
        two.add(nums[0] + nums[3]); // A + D
        two.add(nums[0] + nums[4]); // A + E
        two.add(nums[1] + nums[2]); // B + C
        two.add(nums[1] + nums[3]); // B + D
        two.add(nums[1] + nums[5]); // B + F
        two.add(nums[2] + nums[4]); // C + E
        two.add(nums[2] + nums[5]); // C + F
        two.add(nums[3] + nums[4]); // D + E
        two.add(nums[3] + nums[5]); // D + F
        two.add(nums[4] + nums[5]); // E + F

        Collections.sort(two);

        return two.get(0);
    }
}