import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        int count = 0;
        List<String> list = new ArrayList<>();

        // keySet을 이용해 value 값으로 key 찾기
        for (String key : map.keySet()) {
            // map.get(key) = value 값
            if (map.get(key) == 2) {
                count++;
                list.add(key);
            }
        }
        list.sort(String::compareTo);

        System.out.println(count);
        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);
            System.out.println(key);
        }
    }
}