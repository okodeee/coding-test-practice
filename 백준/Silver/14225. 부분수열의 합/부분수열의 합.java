import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] S = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(S);

        // 부분 합으로 만들 수 없는 가장 작은 자연수 찾기
        int target = 1; // 초기값: 가장 작은 자연수

        for (int num : S) {
            if (num > target) {
                // target을 만들 수 없으면 종료
                break;
            }
            target += num; // num을 포함하여 target 범위 확장
        }

        System.out.println(target);
    }
}