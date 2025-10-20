import java.io.*;
import java.util.*;

public class Main {
    static int[] group;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            group = new int[V + 1];
            graph = new List[V + 1];
            for (int i = 0; i < V + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            boolean answer = true;
            for (int i = 1; i < V + 1; i++) {   // 모든 정점에 대해 체크
                if (group[i] == 0) {
                    if (!bfs(i)) {
                        answer = false;
                        break;
                    }
                }
            }
            System.out.println(answer ? "YES" : "NO");
        }

    }

    static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        group[start] = 1;
        q.offer(start);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph[curr]) {
                if (group[next] == 0) {
                    group[next] = 3 - group[curr];
                    q.offer(next);  // 방금 그룹을 정했으니 충돌나는지 확인해야함
                } else if (group[next] == group[curr]) {
                    return false;
                }
            }
        }

        return true;
    }
}