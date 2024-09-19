import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        String command;
        StringBuilder sb = new StringBuilder();
        int back = 0;
        for (int i = 0; i < N; i++) {
            command = br.readLine();
            switch (command) {
                case "pop":
                    // poll은 가장 앞에 있는 요소를 삭제하며 삭제할 원소가 없을 경우 null 반환
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    // peek()은 큐에 꺼낼 요소가 없을 경우 null 반환
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : back).append('\n');
                    break;
                default:    // push X
                    StringTokenizer st = new StringTokenizer(command);
                    st.nextToken();
                    back = Integer.parseInt(st.nextToken());
                    queue.add(back);
            }
        }
        System.out.print(sb);
    }
}