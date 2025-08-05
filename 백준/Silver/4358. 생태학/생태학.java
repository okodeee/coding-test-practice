import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력을 받을 때 전체 나무 개수 세기
        double total = 0;

        // 입력 받을 때 해시 맵에 해당 종 개수 갱신
        HashMap<String, Integer> tree = new HashMap<>();

        // 사전순으로 출력해야하기 때문에 리스트에 저장
        List<String> name =  new LinkedList<>();

        // 입력이 없을 때까지 반복해서 받기
        String input;
        while ((input = br.readLine()) != null &&  !input.isEmpty()) {  // IntelliJ에서는 null만으로 판별 불가능
            if (!tree.containsKey(input)) {
                name.add(input);
            }

            tree.put(input, tree.getOrDefault(input, 0) + 1);
            total++;
        }

        // 사전순으로 정렬
        Collections.sort(name);

        for (String key : name) {
            int count = tree.get(key);
            System.out.println(key + " " + String.format("%.4f", ((count * 100) / total)));
        }
    }
}