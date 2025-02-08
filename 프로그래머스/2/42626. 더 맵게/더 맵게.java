import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 1. 모든 스코빌 지수를 우선순위 큐에 삽입 (O(N log N))
        for (int s : scoville) {
            pq.add(s);
        }

        int mixCount = 0;

        // 2. 가장 작은 두 개를 계속 섞기 (O(log N) per operation)
        while (pq.size() > 1) {
            if (pq.peek() >= K) { // 최소값이 이미 K 이상이면 종료
                return mixCount;
            }

            int first = pq.poll();   // 가장 작은 값
            int second = pq.poll();  // 두 번째로 작은 값
            int newScoville = first + (second * 2);

            pq.add(newScoville); // 새로운 값 삽입
            mixCount++;
        }

        // 마지막 하나가 K 이상인지 확인
        return (pq.peek() >= K) ? mixCount : -1;
    }
}
