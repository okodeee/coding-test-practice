import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] command = br.readLine().split(" ");

        Deque<Integer> dq = new LinkedList<>();
        // 놓여있는 카드는 순서대로 정렬된 상태
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        // 반대로 실행해보기
        for (int i = N - 1; i >= 0; i--) {
            if (command[i].equals("1")) {
                dq.addFirst(q.poll());
            } else if (command[i].equals("2")) {
                int temp = dq.removeFirst();
                dq.addFirst(q.poll());
                dq.addFirst(temp);
            } else {
                dq.addLast(q.poll());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (dq.size() > 0) {
            sb.append(dq.removeFirst()).append(" ");
        }
        System.out.println(sb);
    }
}