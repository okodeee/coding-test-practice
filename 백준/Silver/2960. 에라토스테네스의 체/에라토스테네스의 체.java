import java.io.*;
import java.util.StringTokenizer;
/* 문제 설명: 소수 판별
 * 핵심 개념: 에라토스테네스의 체
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[1000001];   // false로 초기화
        arr[0] = arr[1] = true;

        for (int i = 2; i <= N; i++) {
            if (arr[i]) continue;   // 이미 소수가 아니면 제외
            if (--K == 0) {
                System.out.println(i);
                break;
            }

            for (int j = i*2; j <= N; j+=i) {   // i의 배수 거르기
                if (arr[j]) continue;
                arr[j] = true;
                if (--K == 0) {
                    System.out.println(j);
                    i = N;  // 종료시키기
                    break;
                }
            }
        }

//        for (int i = 2; i <= N; i++) {
//            if (arr[i]) continue;   // 소수가 아니면 제외
//            System.out.println(i);
//        }
    }
}