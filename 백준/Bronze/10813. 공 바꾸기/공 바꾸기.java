import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있다.
        int[] arr = new int[101];
        for (int i = 1; i < 101; i ++) {
            arr[i] = i;
        }

        int start, end, temp;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}