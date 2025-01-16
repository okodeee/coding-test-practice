import java.io.*;
import java.util.*;

/* 부등호는 K개, 숫자는 K+1 자리
 * 오류 및 문제점 개선
 * 1. Arrays.toString(sequence)은 배열의 모든 요소를 문자열로 출력하지만,
 * 중간에 [, ,, ] 등 불필요한 문자가 포함. 이를 정수로 변환하면 NumberFormatException이 발생
 * 해결 방법: StringBuilder를 사용해 배열을 문자열로 조합한 후 정수로 변환
 * 2. 중복 숫자 체크 로직
 * 반복문 대신 isVisited 배열을 사용하여 간단하고 직관적으로 처리
 */
public class Main {
    static int K;
    static char[] signs;
    static boolean[] isVisited; // 방문 여부 확인
    static List<String> results = new ArrayList<>(); // 모든 결과를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());    // 부등호 개수 입력

        // 부등호 배열 초기화
        signs = new char[K];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            signs[i] = st.nextToken().charAt(0);
        }

        isVisited = new boolean[10];    // 0부터 9까지 사용 가능
        backtrack(0, ""); // 백트래킹 시작

        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));
    }

    public static void backtrack(int idx, String num) {
        // 종료 조건: 부등호를 모두 만족하는 숫자를 만들었을 때
        if (idx == K + 1) { // 0 ~ K 다 채움
            results.add(num);   // 결과 리스트에 추가
            return;
        }

        // 0부터 9까지 숫자 시도
        for (int i = 0; i <= 9; i++) {
            if (!isVisited[i]) {
                // 이전 숫자와 부등호 조건 확인
                if (idx == 0 || isPromising(num.charAt(idx - 1) - '0', i, signs[idx - 1])) {
                    isVisited[i] = true;
                    backtrack(idx + 1, num + i);
                    isVisited[i] = false;
                }
            }
        }
    }

    // 부등호 조건 확인
    static boolean isPromising(int prev, int curr, char sign) {
        if (sign == '<') {
            return prev < curr;
        }
        if (sign == '>') {
            return prev > curr;
        }
        return true;
    }
}