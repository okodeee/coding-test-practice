import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // (key : value)가 (이름, 번호), (번호, 이름)인 hashmap 두 개 생성
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        String name;
        for (int i = 1; i <= N; i++) {
            name = br.readLine();
            map1.put(i, name);
            map2.put(name, i);
        }

        String q;
        for (int i = 0; i < M; i++) {
            q = br.readLine();
            if (q.charAt(0) >= 'A') {
                System.out.println(map2.get(q));
            } else {
                System.out.println(map1.get(Integer.parseInt(q)));
            }
        }
    }
}