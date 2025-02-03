import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph;
    static boolean[] visit;
    static boolean isValid;

    public static void dfs(int node, int depth) {
        // 깊이가 4가 되면 (A -> B -> C -> D -> E 존재) 조건 만족
        if (depth == 4) {
            isValid = true;
            return;
        }

        // 현재 노드 방문 체크
        visit[node] = true;

        // 인접한 친구들 탐색
        for (int next : graph.get(node)) {
            if (!visit[next]) {
                dfs(next, depth + 1);
                if (isValid) return;  // 정답 찾으면 즉시 종료 (가지치기)
            }
        }

        // 백트래킹 (다른 경로 탐색을 위해 방문 취소)
        visit[node] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // 친구 관계 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // DFS를 사용하여 조건 만족하는지 확인
        visit = new boolean[N];
        isValid = false;

        for (int i = 0; i < N; i++) {
            Arrays.fill(visit, false);
            dfs(i, 0); // 깊이 0부터 탐색 시작
            if (isValid) break;  // 정답 찾으면 종료
        }

        System.out.println(isValid ? 1 : 0);
    }
}