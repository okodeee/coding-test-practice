import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int score = Integer.parseInt(br.readLine());

            if (Math.abs(sum + score - 100) <= Math.abs(sum - 100)) {
                sum += score;
            } else {
                break;
            }
        }

        System.out.println(sum);
    }
}