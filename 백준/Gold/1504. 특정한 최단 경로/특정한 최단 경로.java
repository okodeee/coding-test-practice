import java.io.*;
import java.util.*;

public class Main {
    static int N, E;
    static List<Node>[] graph;

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
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1]; // 1-based
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());


        int[] distFrom1 = dijkstra(1);
        int[] distFromU = dijkstra(u);
        int[] distFromV = dijkstra(v);

        // 경로 1: 1 → u → v → N
        int path1 = calculatePath(
            distFrom1[u],
            distFromU[v],
            distFromV[N]
        );

        // 경로 2: 1 → v → u → N
        int path2 = calculatePath(
            distFrom1[v],
            distFromV[u],
            distFromU[N]
        );

        if (path1 == Integer.MAX_VALUE && path2 == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(path1, path2));
    }

    static int[] dijkstra(int start) {
        int[] weight = new int[N + 1];  // dijkstraTable 대신
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 큐에서 꺼낸 가중치가 현재 기록된 최단거리보다 크면 스킵
            if (curNode.weight > weight[curNode.end]) {
                continue;
            }

            for (Node nextNode : graph[curNode.end]) {
                int newWeight = curNode.weight + nextNode.weight;

                if (newWeight < weight[nextNode.end]) {
                    weight[nextNode.end] = newWeight;
                    pq.add(new Node(nextNode.end, weight[nextNode.end]));
                }
            }
        }

        return weight;
    }

    private static int calculatePath(int dist1, int dist2, int dist3) {
        if (dist1 == Integer.MAX_VALUE ||
            dist2 == Integer.MAX_VALUE ||
            dist3 == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return dist1 + dist2 + dist3;
    }
}