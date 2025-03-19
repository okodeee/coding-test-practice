import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];  // 탑 높이 저장

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            int currHeight = heights[i];

            // 스택의 맨 위에 있는 탑이 현재 탑보다 작다면 pop (신호를 받을 수 없음)
            while (!stack.isEmpty() && stack.peek()[1] < currHeight) {
                stack.pop();
            }

            // 스택이 비어 있지 않다면 신호를 받을 탑이 존재
            if (!stack.isEmpty()) {
                result[i] = stack.peek()[0] + 1;
            } else {
                result[i] = 0;
            }

            // 현재 탑을 스택에 push (탑의 번호, 높이 저장)
            stack.push(new int[]{i, currHeight});
        }

        for (int r : result) {
            sb.append(r).append(" ");
        }
        System.out.println(sb);
    }
}