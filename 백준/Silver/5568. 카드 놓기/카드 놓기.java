import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static boolean[] visited;
    static String[] arr;
    static ArrayList<String> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        visited = new boolean[n];
        list = new ArrayList<>();

        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        dfs(0, "");
        System.out.println(list.size());
    }

    static void dfs(int count, String tmp) {

        if (count == k) { // k개만 뽑는다
            if (!list.contains(tmp)) { // 이미 있는 숫자라면 추가하지 않음
                list.add(tmp);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(count + 1, tmp+arr[i]);
                visited[i] = false;
            }
        }
    }
}