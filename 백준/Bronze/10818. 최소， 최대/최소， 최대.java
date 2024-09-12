import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int least = 1000000;
        int greatest = -1000000;
        int temp;

        for(int i = 1; i <= n; i++){
             temp = Integer.parseInt(st.nextToken());

             if (temp < least){
                 least = temp;
             }
             if (temp > greatest){
                 greatest = temp;
             }
        }

        System.out.println(least + " " + greatest);
    }
}