import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[] population;
    static int[] area;  // 선거구1, 선거구2
    static List<Integer>[] graph;
    static int answer = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        area = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num ; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        minDiff(1, 0);

        System.out.println(answer == 1000 ? -1 : answer);
    }

    static void minDiff(int start, int count) {
        if (count == N) {
            int one = 0, two = 0;
            for (int i = 1; i <= N; i++) {
                if (area[i] == 1) {
                    one++;
                } else {
                    two++;
                }
            }

            if (isValid(one, two) && isConnected(one, two)) {
                // 최솟값 업데이트
                int oneP = 0, twoP = 0;
                for (int i = 1; i <= N; i++) {
                    if (area[i] == 1) {
                        oneP += population[i];
                    } else {
                        twoP += population[i];
                    }
                }

                answer = Math.min(answer, Math.abs(oneP - twoP));
            }
            return;
        }

        area[start] = 1;
        minDiff(start + 1, count + 1);

        area[start] = 2;
        minDiff(start + 1, count + 1);
    }

    // 선거구는 구역을 적어도 하나 포함해야함
    static boolean isValid(int one, int two) {
        if (one == 0 || two == 0) return false;
        return true;
    }

    // 선거구는 인접해 있어야 함
    static boolean isConnected(int one, int two) {
        int oneStart = 0, twoStart = 0;

        for (int i = 1; i <= N; i++) {
            if (area[i] == 1) {
                oneStart = i;
                break;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (area[i] == 2) {
                twoStart = i;
                break;
            }
        }

        // 선거구1 연결되어있는가
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.offer(oneStart);
        visited[oneStart] = true;

        int oneCount = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            oneCount++;

            for (int next : graph[cur]) {
                if (!visited[next] && area[next] == 1) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        if (oneCount != one) return false;

        // 선거구2 연결되어있는가
        q = new LinkedList<>();
        visited = new boolean[N + 1];

        q.offer(twoStart);
        visited[twoStart] = true;

        int twoCount = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            twoCount++;

            for (int next : graph[cur]) {
                if (!visited[next] && area[next] == 2) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        if (twoCount != two) return false;

        return true;
    }
}