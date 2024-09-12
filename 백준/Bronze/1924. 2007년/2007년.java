import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int n = 0;  // 지난 일수
        for(int i = 1; i < x; i++){ // 해당 전월까지의 일수
            n += months[i];
        }
        n += (y - 1);   // 해당 월의 일수

        System.out.println(days[n % 7]);
    }
}