import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트케이스
        int[] priority = new int[100];  // 문서의 중요도
        int N, paper;  // 문서의 개수와 내가 궁금한 문서
        Queue<int[]> q;  // 프린터 큐
        PriorityQueue<Integer> pq;  // 중요도 순서를 알아보기 위해

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            paper = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();
            pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위가 높은 숫자가 먼저 나옴 (큰 숫자)

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                priority[j] = Integer.parseInt(st.nextToken());
                q.add(new int[]{j, priority[j]});   // 각각의 초기 위치, 중요도
                pq.add(priority[j]);
            }

            // 프린터 큐 작동
            int cnt = 1;
            while(true) {
                if (pq.peek() == q.peek()[1]) {
                    if (q.peek()[0] == paper) {
                        System.out.println(cnt);
                        break;
                    }
                    pq.poll(); q.poll();
                    cnt++;
                } else {
                    q.add(q.poll());
                }
            }
        }
    }
}