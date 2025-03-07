import java.io.*;
import java.util.*;

/*
 * BFS는 최단 경로를 찾을 때 가장 적합한 알고리즘
 * BFS 탐색 → O(N)
 * 각 위치(0 ~ 100,000 최대 100,000개)를 한 번씩 방문
 * 최대 100,000번 연산
 *
 * 0-1 BFS 주의점
 * https://www.acmicpc.net/board/view/144960
 */
public class Main {
    static final int MAX = 100000;
    static int N, K;
    static int[] time = new int[MAX + 1]; // 방문한 위치를 기록하여 중복 방지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        time[start] = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == K) return time[x] - 1;

            // 순간이동 먼저 처리 (0초)
            // time[] == 0 아직 방문하지 않은 위치
            if (x * 2 <= MAX && time[x * 2] == 0) {
                time[x * 2] = time[x];
                queue.offer(x * 2);
            }

            // 걷기 (-1, +1) (1초)
            if (x - 1 >= 0 && time[x - 1] == 0) {
                time[x - 1] = time[x] + 1;
                queue.offer(x - 1);
            }
            if (x + 1 <= MAX && time[x + 1] == 0) {
                time[x + 1] = time[x] + 1;
                queue.offer(x + 1);
            }
        }
        return -1;
    }
}
