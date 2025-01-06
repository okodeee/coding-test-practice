import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String st = br.readLine();

            for (int j = 0; j < st.length(); j++) {
                if (!stack.isEmpty() && stack.peek() == st.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(st.charAt(j));
                }
            }
            if (stack.isEmpty()) result++;
        }
        System.out.println(result);
    }
}