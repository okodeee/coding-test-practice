import java.io.*;
import java.util.*;


public class Main {
    static int R;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] count; // 각 정점을 루트로 하는 서브트리에 속한 정점의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N + 1];
        count = new int[N + 1];

        subTree(R); // 서브트리 정점 수 구하기

        for (int i = 0; i < Q; i++) {
            System.out.println(count[Integer.parseInt(br.readLine())]);
        }
    }

    static void subTree(int root) {
        if (graph[root].size() == 1 && root != R) { // 리프 노드 (자식이 없음)
            count[root] = 1;
            return;
        }

        visited[root] = true;   // 부모 노드로 올라가는 것 방지

        int cnt = 0;
        for (int child : graph[root]) {
            if (!visited[child]) {
                subTree(child);
                cnt += count[child];  // 본인을 포함한 서브트리의 정점 수
            }
        }

        count[root] = cnt + 1;
    }
}