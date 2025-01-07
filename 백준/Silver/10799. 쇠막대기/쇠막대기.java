import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int result = 0;
        Stack<Character> stack = new Stack<>();

        stack.push(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == ')' && input.charAt(i - 1) == '(') {
                stack.pop();
                result += stack.size();
            } else if (input.charAt(i) == ')') {
                stack.pop();
                result++;
            } else {
                stack.push(input.charAt(i));
            }
        }
        System.out.println(result);
    }
}