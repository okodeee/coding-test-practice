import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i = 1; i <= n; i++){ // 해당 전월까지의 일수
            sum += i;
        }

        System.out.println(sum);
    }
}