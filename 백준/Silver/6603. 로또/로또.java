import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            set = new int[k];
            for (int i = 0; i < k; i++) {
                set[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> result = new ArrayList<>();
            rec(0, result);

            System.out.println();
        }
    }

    private static void rec(int depth, List<Integer> result) {
        if (result.size() == 6) {
            printSet(result);
            return;
        }

        if (depth == k) {
            return;
        }

        // 요소 넣기
        List<Integer> newResult = new ArrayList<>(result);
        newResult.add(set[depth]);
        rec(depth + 1, newResult);

        // 요소 안 넣기
        rec(depth + 1, result);
    }

    private static void printSet(List<Integer> result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + " ");
        }
        System.out.println(sb);
    }
}