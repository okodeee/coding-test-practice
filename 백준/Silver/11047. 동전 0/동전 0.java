import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(bf.readLine());

        int ans = 0;
        for(int i=n-1; i>=0; i--){
            ans += k/arr[i];
            k %= arr[i];
        }

        System.out.println(ans);
    }
}
