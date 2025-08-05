import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            String input = br.readLine();

            for (char c : input.toCharArray()) {
                if (c == '-') {
                    // left stack 하나 빼기
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else if (c == '<') {
                    // left stack 하나를 right stack으로 이동
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                } else if (c == '>') {
                    // right stack 하나를 left stack으로 이동
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                } else {
                    // left stack에 쌓기
                    left.push(c);
                }
            }

            // 문자열 만들기
            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            StringBuilder sb = new StringBuilder();
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }

            System.out.println(sb);
        }
    }
}