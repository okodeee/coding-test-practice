import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = new ArrayList<>();

        for (int i = N; i > 0; i--) {
            result.add(input[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + " ");
        }
        System.out.println(sb);
    }
}