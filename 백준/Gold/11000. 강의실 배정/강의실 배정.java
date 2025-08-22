import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<int[]> lectures = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s =  Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            lectures.add(new int[] {s, t});
        }

        // 강의 시작 시작 기준으로 정렬
        lectures.sort((int[] o1, int[] o2) -> { return o1[0] - o2[0]; });

        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] lecture : lectures) {
            while(!pq.isEmpty() && pq.peek() <= lecture[0]) {
                pq.poll();  // 지난 강의 빼기
            }
            pq.add(lecture[1]);
            result = Math.max(result, pq.size());
        }

        System.out.println(result);
    }
}