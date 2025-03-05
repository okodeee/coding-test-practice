import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, sequence;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sequence = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backtrack(0, 0, -1);
        System.out.println(sb);
    }

    // 비내림차순 조합 생성하기
    static void backtrack(int depth, int start, int lastUsed) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i = start; i < N; i++) {
            if (arr[i] == prev) continue; // 같은 조합을 만들지 않도록
            
            sequence[depth] = arr[i]; // 현재 숫자 선택
            backtrack(depth + 1, i, arr[i]); // 현재 인덱스 i부터 (중복 허용)
            prev = arr[i]; // 이전 값 갱신
        }
    }
}