import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String s = br.readLine();
            sb.append(solution(s)).append("\n");
        }

        System.out.println(sb);
    }

    private static String solution(String s){
        Stack<Character> stack = new Stack<>();

        for(int j=0; j<s.length(); j++){
            char c = s.charAt(j);

            if(c == '('){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return "NO";
                }
                stack.pop();
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

}