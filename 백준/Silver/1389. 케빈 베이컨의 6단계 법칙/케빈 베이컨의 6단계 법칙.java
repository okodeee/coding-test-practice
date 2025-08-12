import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트로 그래프 구성
        List<List<Integer>> relation = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            relation.add(new ArrayList<>());
        }

        // 친구 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation.get(a).add(b);
            relation.get(b).add(a);
        }

        int minSum = Integer.MAX_VALUE;
        int result = 1;

        // 각 사람에 대해 BFS 수행
        for (int start = 1; start <= N; start++) {
            int sum = bfs(relation, start, N);

            if (sum < minSum) {
                minSum = sum;
                result = start;
            }
        }

        System.out.println(result);
    }

    static int bfs(List<List<Integer>> relation, int start, int N) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        // BFS
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            // 인접한 모든 정점 탐색
            for (int next : relation.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[curr] + 1;    // 거리 1씩 증가
                    queue.offer(next);
                }
            }
        }

        // 거리 합 계산 (자기 자신 제외)
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (i != start) {
                sum += dist[i];
            }
        }

        return sum;
    }
}