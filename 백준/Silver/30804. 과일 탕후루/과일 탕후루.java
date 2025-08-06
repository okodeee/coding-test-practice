import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N < 2) {
            System.out.println(N);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> fruitCount = new HashMap<>();

        int start = 0;
        int end = 1;
        fruitCount.put(fruits[0], 1);
        fruitCount.put(fruits[1], fruitCount.getOrDefault(fruits[1], 0) + 1);
        int value = 2;  // 해당 구간에 과일 개수
        int max = 2;

        while (end < N - 1) {
            fruitCount.put(fruits[end + 1], fruitCount.getOrDefault(fruits[end + 1], 0) + 1);
            if (fruitCount.size() > 2) {
                fruitCount.put(fruits[start], fruitCount.get(fruits[start]) - 1);

                // 해당 과일의 개수가 0이 되면 Map에서 완전히 제거
                if (fruitCount.get(fruits[start]) == 0) {
                    fruitCount.remove(fruits[start]);
                }

                start++;
            } else {
                value++;
                if (max < value) max = value;
            }

            end++;
        }


        System.out.println(max);
    }
}