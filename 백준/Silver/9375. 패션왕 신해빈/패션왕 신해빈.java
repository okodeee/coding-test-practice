import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();
                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            int result = 1;
            for (String key : map.keySet()) {
                result *= map.get(key) + 1;
            }

            System.out.println(result - 1);
        }
    }
}
