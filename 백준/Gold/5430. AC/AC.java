import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            String command = br.readLine();

            int num = Integer.parseInt(br.readLine());

            String input = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            if (!input.equals("[]")) {
                input = input.replaceAll("[\\[\\]\\s]", "");
                String[] tokens = input.split(",");
                for (String token : tokens) {
                    deque.add(Integer.parseInt(token));
                }
            }

            boolean front = true;
            boolean error = false;
            for (int i = 0; i < command.length(); i++) {
                char c = command.charAt(i);

                if (c == 'R') {
                    // 뒤집기
                    front = !front;
                } else if (c == 'D') {
                    if (front) {
                        // 앞에서 빼기
                        if (deque.isEmpty()) {
                           error = true;
                            break;
                        }
                        deque.pollFirst();
                    } else {
                        // 뒤에서 빼기
                        if (deque.isEmpty()) {
                            error = true;
                            break;
                        }
                        deque.pollLast();
                    }
                }
            }
            if (error) {
                System.out.println("error");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            if (deque.isEmpty()) {
                sb.append('[').append(']');
            } else {
                sb.append('[');
                if (front) {
                    // 앞에서부터 빼기
                    while (deque.size() > 1) {
                        sb.append(deque.poll()).append(',');
                    }
                    sb.append(deque.poll());
                } else {
                    // 뒤에서부터 빼기
                    while (deque.size() > 1) {
                        sb.append(deque.pollLast()).append(',');
                    }
                    sb.append(deque.pollLast());
                }
                sb.append(']');
            }
            System.out.println(sb.toString());
        }
    }
}