import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String input = br.readLine();

        for (char c : input.toCharArray()) {
            left.push(c);
        }

        int num = Integer.parseInt(br.readLine());

        while (num-- > 0) {
            String command = br.readLine();
            if (command.equals("L") && !left.isEmpty()) {
                right.push(left.pop());
            } else if (command.equals("D") && !right.isEmpty()) {
                left.push(right.pop());
            } else if (command.equals("B") && !left.isEmpty()) {
                left.pop();
            } else if (command.charAt(0) == 'P') {
                left.push(command.charAt(2));
            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}