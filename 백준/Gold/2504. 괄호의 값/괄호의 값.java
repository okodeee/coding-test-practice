import java.io.*;
import java.util.*;

/*
 * Object로 Character + Integer 혼합 처리
 * instanceof => 객체 타입을 확인하는 연산자
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Object> stack = new Stack<>();

        boolean isValid = true;

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c); // 여는 괄호 스택에 넣기
            } else {
                int temp = 0;

                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    temp += (int) stack.pop(); // 숫자는 모두 더해둠
                }

                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }

                char top = (char) stack.pop();

                if ((c == ')' && top != '(') || (c == ']' && top != '[')) {
                    isValid = false;
                    break;
                }

                if (temp == 0) {
                    stack.push(c == ')' ? 2 : 3); // () → 2, [] → 3
                } else {
                    stack.push((c == ')' ? 2 : 3) * temp); // 감싸진 값: 2*X or 3*X
                }
            }
        }

        if (!isValid) {
            System.out.println(0);
            return;
        }

        int result = 0;
        for (Object o : stack) {
            if (o instanceof Integer) {
                result += (int) o;
            } else {
                // 괄호가 남아 있다면 올바르지 않은 괄호열
                result = 0;
                break;
            }
        }

        System.out.println(result);
    }
}