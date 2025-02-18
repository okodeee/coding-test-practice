import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sumQueue1 = 0;
        long sumQueue2 = 0;
        long maxQueue1 = 0;
        long maxQueue2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            sumQueue1 += queue1[i];
            maxQueue1 = Math.max(maxQueue1, queue1[i]);
            q1.offer(queue1[i]);
        }
        for (int i = 0; i < queue2.length; i++) {
            sumQueue2 += queue2[i];
            maxQueue2 = Math.max(maxQueue2, queue2[i]);
            q2.offer(queue2[i]);
        }
        long avg = (sumQueue1 + sumQueue2) / 2;
        
        if (maxQueue1 > avg || maxQueue2 > avg) return -1;
        
        while(sumQueue1 != sumQueue2) {
            if (sumQueue1 < sumQueue2) {
                sumQueue2 -= q2.peek();
                sumQueue1 += q2.peek();
                q1.offer(q2.poll());
            } else {
                sumQueue1 -= q1.peek();
                sumQueue2 += q1.peek();
                q2.offer(q1.poll());
            }
            answer++;
            if (answer > queue1.length * 4) return -1;
        }
        
        return answer;
    }
}