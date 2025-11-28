import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while (pq.size() > 1) {
                long c1 = pq.poll();
                long c2 = pq.poll();
                sum += c1 + c2;
                pq.offer(c1 + c2);
            }

            System.out.println(sum);
        }
    }
}