import java.io.*;
import java.math.BigInteger;
import java.util.Stack;

// BigInteger****
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        BigInteger sum = new BigInteger("0");
        String str;
        int num = 0;
        for (int i = 0; i < K; i++) {
            str = br.readLine();
            num = Integer.parseInt(str);
            if (num == 0) {
                sum = sum.subtract(BigInteger.valueOf(stack.pop()));
                continue;
            }
            stack.push(num);
            sum = sum.add(BigInteger.valueOf(stack.peek()));
        }
        System.out.println(sum);
    }
}
