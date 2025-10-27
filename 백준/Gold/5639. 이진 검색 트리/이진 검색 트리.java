import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        String input = "";
        while ((input = br.readLine()) != null && !input.equals("")) {
            list.add(Integer.parseInt(input));
        }
        depth(list);
    }

    static void depth(List<Integer> list) {
        if (list.size() == 1) {
            System.out.println(list.get(0));
            return;
        }

        int node = list.get(0);
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > node) {
                index = i;
                break;
            }
        }

        // 작은 값
        if (index > 1) {
            depth(list.subList(1, index));
            depth(list.subList(index, list.size()));
        } else {
            depth(list.subList(1, list.size()));
        }

        // 노드 자신
        depth(list.subList(0, 1));
    }

}