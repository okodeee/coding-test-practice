import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] expression = new int[2 * N - 1];
            expression[0] = 1;

            makeExpression(N, 1, expression);
            System.out.println();
        }

    }

    static void makeExpression(int N, int depth, int[] expression) {
        if (depth == N) {
            // 수식의 결과가 0인지 확인
            if (isZero(expression)) {
                printExpression(expression);
            }

            return;
        }

        expression[2 * depth] = depth + 1;

        expression[2 * depth - 1] = ' ';
        makeExpression(N, depth + 1, expression);
        expression[2 * depth - 1] = '+';
        makeExpression(N, depth + 1, expression);
        expression[2 * depth - 1] = '-';
        makeExpression(N, depth + 1, expression);

    }

    static boolean isZero(int[] expression) {
        int result = 0;
        int currNum = 0;
        int operator = '+';

        for (int i = 0; i < expression.length; i++) {
            if (expression[i] == '-') {
                if (operator == '-') {
                    result -= currNum;
                } else {
                    result += currNum;
                }

                operator = '-';
            } else if (expression[i] == '+') {
                if (operator == '-') {
                    result -= currNum;
                } else {
                    result += currNum;
                }

                operator = '+';
            } else if (expression[i] == ' ') {
                currNum *= 10;
                currNum += expression[i + 1];
                i++;
            } else {
                currNum = expression[i];
            }
        }

        if (operator == '-') {
            result -= currNum;
        } else {
            result += currNum;
        }

        if (result == 0) return true;
        return false;
    }

    static void printExpression(int[] expression) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length; i++) {
            if (expression[i] == '-' || expression[i] == '+' || expression[i] == ' ') {
                sb.append((char)expression[i]);
                continue;
            }
            sb.append(expression[i]);
        }
        System.out.println(sb);
    }
}