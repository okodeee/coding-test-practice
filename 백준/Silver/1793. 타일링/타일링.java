import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null &&  !input.isEmpty()) {

            int n = Integer.parseInt(input);

            if (n == 0) {
                System.out.println(1);
            } else if (n == 1) {
                System.out.println(1);
            } else {
                BigInteger[] dp = new BigInteger[n + 1];
                dp[0] = dp[1] = new BigInteger("1");
                for (int i = 2; i <= n; i++) {
                    dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
                }

                System.out.println(dp[n]);
            }
        }
    }
}