import java.util.*;
import java.io.*;

public class Main {
    static int V, E, K;
    static ArrayList<Node>[] graph;
    static boolean[] isVisited;
    static int[] dijkstraTable; // 최단 경로 값 저장

    static class Node {
        int n;
        int weight;

        Node(int n, int weight) {
            this.n = n;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w)); // 최단 거리로 갱신
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dijkstraTable[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dijkstraTable[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void dijkstra(int s) {
        isVisited = new boolean[V + 1];
        dijkstraTable = new int[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;   // 람다함수
        });

        Arrays.fill(dijkstraTable, Integer.MAX_VALUE);
        dijkstraTable[s] = 0;
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node curnode = pq.poll();   // 현재 방문 정점
            if (!isVisited[curnode.n]) isVisited[curnode.n] = true; // 방문처리

            // 현재 정점과 연결된 간선들에 대해 판단
            for (Node node : graph[curnode.n]) {
                // 다음 정점을 방문하지 않았고,
                // 현재 가중치 + 해당 정점으로 향하는 가중치 < 해당 정점으로의 최단 경로 값
                if (!isVisited[node.n] && curnode.weight + node.weight < dijkstraTable[node.n]) {
                    dijkstraTable[node.n] = curnode.weight + node.weight;
                    pq.add(new Node(node.n, dijkstraTable[node.n]));
                }
            }
        }
    }
}