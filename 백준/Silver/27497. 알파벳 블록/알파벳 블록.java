import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> line = new ArrayDeque<>();

        // 커맨드 기록할 스택
        Stack<Character> position = new Stack<>();

        int count = Integer.parseInt(br.readLine());

        String command;
        while (count-- > 0) {
            command =  br.readLine();

            if (command.charAt(0) == '1') {
                line.offerLast(command.charAt(2));
                position.push('1');
            } else if (command.charAt(0) == '2') {
                line.offerFirst(command.charAt(2));
                position.push('2');
            } else if (command.charAt(0) == '3' && !line.isEmpty()) {
                if (!position.isEmpty() && position.pop() == '1') {
                    line.pollLast();
                } else {
                    line.pollFirst();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!line.isEmpty()) {
            sb.append(line.pollFirst());
        }
        if (sb.length() == 0) {
            sb.append('0');
        }

        System.out.println(sb);
    }
}