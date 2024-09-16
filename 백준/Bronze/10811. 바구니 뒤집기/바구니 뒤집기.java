import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];
        for (int i = 1; i < 101; i ++) {
            arr[i] = i;
        }

        int start, end, temp;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            for (int j = start; j <= (start + end)/2; j++) {
                temp = arr[j];
                arr[j] = arr[end - j + start];
                arr[end - j + start] = temp;
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}