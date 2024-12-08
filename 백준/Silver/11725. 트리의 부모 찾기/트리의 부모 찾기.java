import java.io.*;
import java.util.*;

/*
 * 그래프를 인접리스트 형태로 구현한다.
 * 인접 행렬 방식은 연결되지 않은 노드 정보도 포함해 메모리가 불필요하게 낭비된다.
 * 인접 행렬로 구현 시 N이 최대일 때 100만 * 4B = 4GB
 */
public class Main {
    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] parents;

    public static void dfs(int V) {
        visit[V] = true;

        for (int i : adj[V]) {
            if (!visit[i]) {
                parents[i] = V;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        parents = new int[N + 1];

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }
}
