import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] students;
    static boolean[] isVisited;
    static List<Integer> joined;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            students = new int[N + 1];
            isVisited = new boolean[N + 1];
            joined = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!isVisited[i]) {
                    dfs(i, new ArrayList<>());
                }
            }

            System.out.println(N - joined.size());
        }
    }

    static void dfs(int start, List<Integer> path) {
        if (isVisited[start]) {
            if (path.contains(start)) {
                int idx = path.indexOf(start);
                for (int i = idx; i < path.size(); i++) {
                    joined.add(path.get(i));
                }
            }
            // 사이클 돌았으니 종료
            return;
        }

        isVisited[start] = true;
        path.add(start);
        dfs(students[start], path);
    }
}