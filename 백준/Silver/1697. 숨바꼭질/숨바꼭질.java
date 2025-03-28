import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 예외 처리 추가
        if (N == K) {
            System.out.println(0);
            return;
        }

        bfs();

        System.out.println(time[K]);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current - 1 >= 0 && current - 1 <= 100000 && time[current - 1] == 0) {
                time[current - 1] = time[current] + 1;
                if (current - 1 == K) break;
                queue.offer(current - 1);
            }
            if (current + 1 >= 0 && current + 1 <= 100000 && time[current + 1] == 0) {
                time[current + 1] = time[current] + 1;
                if (current + 1 == K) break;
                queue.offer(current + 1);
            }
            if (current * 2 >= 0 && current * 2 <= 100000 && time[current * 2] == 0) {
                time[current * 2] = time[current] + 1;
                if (current * 2 == K) break;
                queue.offer(current * 2);
            }
        }
    }
}