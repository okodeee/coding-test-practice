import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            List<String> numbers = new ArrayList<>();

            // 입력을 먼저 모두 받을 후 길이순으로 정렬
            for (int i = 0; i < N; i++) {
                numbers.add(br.readLine());
            }
            Collections.sort(numbers);

            Map<String, Integer> numbersCount = new HashMap<>();
            boolean isValid = true;

            for (String number : numbers) {
                // 해당 전화번호의 접두어가 있는지
                for (int j = 1; j <= number.length(); j++) {
                    String prefix = number.substring(0, j);

                    if (numbersCount.getOrDefault(prefix, 0) == 1) { // 일관성 없음
                        isValid = false;
                        break;
                    }
                }

                // 해당 전화번호 저장
                if (isValid) {
                    numbersCount.put(number, 1);
                }
            }

            System.out.println(isValid ? "YES" : "NO");
        }
    }
}