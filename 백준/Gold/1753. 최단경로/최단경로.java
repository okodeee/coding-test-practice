import java.io.*;
import java.util.*;

public class Main {

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
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        // 다익스트라 알고리즘 실행
        int[] distance = dijkstra(graph, V, K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(distance[i]).append('\n');
            }
        }

        System.out.println(sb);
    }

    static int[] dijkstra(List<List<Node>> graph, int V, int start) {
        int[] distance = new int[V + 1]; // 최단거리 배열
        Arrays.fill(distance, Integer.MAX_VALUE); // 무한대로 초기화
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[V + 1];
        while (!pq.isEmpty()) {
            Node current = pq.poll(); // 가장 가까운 노드 꺼내기
            if (!visited[current.end]) visited[current.end] = true;

            int curEnd = current.end;
            int curWeight = current.weight;

            // 현재 정점과 연결된 모든 간선 확인
            for (Node node : graph.get(curEnd)) {
                int nextEnd = node.end;
                int nextWeight = curWeight + node.weight;

                // 더 짧은 경로를 발견하면 업데이트
                if (!visited[nextEnd] && nextWeight < distance[nextEnd]) {
                    distance[nextEnd] = nextWeight;
                    pq.offer(new Node(nextEnd, nextWeight));
                }
            }
        }

        return distance;
    }
}