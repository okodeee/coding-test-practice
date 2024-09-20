import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String expression = br.readLine();

        double[] operands = new double[26];
        for (int i = 0; i < N; i++) {
            operands[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        double temp1, temp2;
        for (char c : expression.toCharArray()) {
            if (65 <= c && c <= 90) {
                stack.push(operands[c - 65]);
            } else {
                temp2 = stack.pop();
                temp1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(temp1 + temp2);
                        break;
                    case '-':
                        stack.push(temp1 - temp2);
                        break;
                    case '*':
                        stack.push(temp1 * temp2);
                        break;
                    case '/':
                        stack.push(temp1 / temp2);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop()); // 소수점 둘째 자리까지 출력
    }
}