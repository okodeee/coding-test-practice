import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Node>[] graph;
    static int[] dijkstraTable; // 최단 경로 값 저장

    static class Node {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, 1));
        }

        dijkstra(X, K);
    }

    static void dijkstra(int s, int k) {
        dijkstraTable = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;   // 람다함수
        });

        Arrays.fill(dijkstraTable, Integer.MAX_VALUE);
        dijkstraTable[s] = 0;
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node curnode = pq.poll();   // 현재 방문 정점

            // 정점까지 오는 비용이 다른 루트로 방문하는 비용보다 비싸면 넘어간다. (최적화)
            if (curnode.weight > dijkstraTable[curnode.end]) continue;

            // 현재 정점과 연결된 간선들에 대해 판단
            for (Node node : graph[curnode.end]) {
                // 다음 정점 현재 최소 비용이 현재 정점에서 다음 정점으로 가는 비용보다 크면 이를 업데이트한다.
                if (curnode.weight + node.weight < dijkstraTable[node.end]) {
                    dijkstraTable[node.end] = curnode.weight + node.weight;
                    pq.add(new Node(node.end, dijkstraTable[node.end]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++ ) {
            if (dijkstraTable[i] == k) sb.append(i).append("\n");
        }
        if (sb.isEmpty()) sb.append(-1).append("\n");

        System.out.println(sb);
    }
}