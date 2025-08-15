import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 문제 1: k번째 순열 구하기
        if (st.nextToken().equals("1")) {
            long k = Long.parseLong(st.nextToken());
            int[] result = getKthPermutation(N, k);

            // 결과 출력
            for (int num : result) {
                System.out.print(num + " ");
            }

        } else {    // 문제 2: 주어진 순열이 몇 번째인지 구하기
            int[] permutation = new int[N];
            for (int i = 0; i < N; i++) {
                permutation[i] = Integer.parseInt(st.nextToken());
            }

            long rank = getPermutationRank(permutation);
            System.out.println(rank);
        }
    }

    /**
     * k번째 순열을 구하는 메소드
     * 팩토리얼 진법을 이용한 알고리즘
     */
    static int[] getKthPermutation(int n, long k) {
        // 팩토리얼 값 초기화
        long[] factorial = new long[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // 사용 가능한 숫자들 (1부터 n까지)
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        int[] result = new int[n];
        k--;    // 0-based 로 변환

        // 각 자리수별로 순열 구하기
        for (int i = 0; i < n; i++) {
            // 현재 자리에서 선택할 숫자의 인덱스 계산
            // k를 (n-1-i)!로 나눈 몫이 선택할 숫자의 순서
            int index = (int)(k / factorial[n - 1 - i]);

            result[i] = numbers.get(index);
            numbers.remove(index);

            // k를 나머지 값으로
            k %= factorial[n - 1 - i];
        }

        return result;
    }

    /**
     * 주어진 순열이 몇 번째 순열인지 구하는 메소드
     * 역방향 팩토리얼 진법 계산
     */
    static long getPermutationRank(int[] permutation) {
        int n = permutation.length;

        // 팩토리얼 값 초기화
        long[] factorial = new long[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // 사용 가능한 숫자들
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        long rank = 0;

        // 각 자리수별로 순위 계산하기
        for (int i = 0; i < n; i++) {
            // 현재 숫자가 남은 숫자들 중에서 몇 번째로 작은지 찾기
            int curr = permutation[i];
            int index = numbers.indexOf(curr);

            // 이 숫자보다 작은 숫자들로 시작하는 순열의 개수 더하기
            // index개의 더 작은 숫자 * (n-1-i)! = 해당 순열들의 개수
            rank += index * factorial[n - 1 - i];

            numbers.remove(index);
        }

        return rank + 1;
    }
}