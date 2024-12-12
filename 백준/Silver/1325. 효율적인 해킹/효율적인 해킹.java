import java.io.*;
import java.util.*;
/*
 * 그니까 어떤 애가 제일 해킹을 많이 당하는지가 아니라 해킹시키냐는 거잖아.
 * 나를 해킹시킨 놈이 누구냐. 거슬러 올라가면서 숫자를 증가시키자.
 * 3 -> 1 -> 2 해킹시킨다면 3과 1의 숫자를 증가시키기.
 * 다음에 3 -> 1 의 case 계산할 때, 3의 숫자 증가.
 */

public class Main {
    static int N, M;
    static ArrayList<Integer>[] reverseGraph;
    static boolean[] visit;

    // 특정 노드에서 도달 가능한 노드 수를 반환하는 DFS
    public static int dfs(int V) {
        visit[V] = true;
        int count = 1;  // 자신도 포함
        for (int next : reverseGraph[V]) {
            if (!visit[next]) {
                count += dfs(next);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        reverseGraph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            reverseGraph[B].add(A); // 방향을 반대로 저장
        }

        int[] result = new int[N + 1];
        int max = 0;

        // 각 노드에서 도달 가능한 노드 수 계산
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            result[i] = dfs(i);
            max = Math.max(max, result[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
}
