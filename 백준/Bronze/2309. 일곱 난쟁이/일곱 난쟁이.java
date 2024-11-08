import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] x = new int[9];
        for (int i = 0; i < 9; i++){
            x[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(x);
        int sum = 0;
        for (int i = 0; i < 9; i++){
            sum += x[i];
        }
//        System.out.println(sum);
        int a = -1;
        int b = -1;
        for (int i =0 ; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (i == j) continue;
                if (sum - x[i] - x[j] == 100){
                    a = x[i];
                    b = x[j];
                }
            }
        }
//        System.out.println(a + " " + b);
        for (int i = 0; i < 9; i++){
            if (x[i] == a || x[i] == b) continue;
            System.out.println(x[i]);
        }
    }
}