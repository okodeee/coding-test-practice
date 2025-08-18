import java.io.*;
import java.util.*;

public class Main {
    static int N, D;
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
        D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < D; i++) {
            graph[i].add(new Node(i + 1, 1)); // i에서 i+1로 거리 1
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 지름길이 고속도로 범위 내에 있고, 실제로 이득이 있을 때만 추가
            if (v <= D && w < v - u) {
                graph[u].add(new Node(v, w));
            }
        }

        System.out.println(dijkstra(0));
    }

    static int dijkstra(int s) {
        dijkstraTable = new int[D + 1];
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
        return dijkstraTable[D];
    }
}