import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Node>[] graph;
//    static boolean[] isVisited;
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
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));

    }

    static int dijkstra(int s, int e) {
//        isVisited = new boolean[N + 1];
        dijkstraTable = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;   // 람다함수
        });

        Arrays.fill(dijkstraTable, Integer.MAX_VALUE);
        dijkstraTable[s] = 0;
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node curnode = pq.poll();   // 현재 방문 정점
//            if (!isVisited[curnode.end]) isVisited[curnode.end] = true; // 방문처리

            if (curnode.weight > dijkstraTable[curnode.end]) continue;

            // 현재 정점과 연결된 간선들에 대해 판단
            for (Node node : graph[curnode.end]) {
                // 다음 정점을 방문하지 않았고,
                // 현재 가중치 + 해당 정점으로 향하는 가중치 < 해당 정점으로의 최단 경로 값
                if (curnode.weight + node.weight < dijkstraTable[node.end]) {
                    dijkstraTable[node.end] = curnode.weight + node.weight;
                    pq.add(new Node(node.end, dijkstraTable[node.end]));
                }
            }
        }
        return dijkstraTable[e];
    }
}