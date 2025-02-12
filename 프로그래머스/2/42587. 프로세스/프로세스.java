import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int result_priority = priorities[location];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(new int[]{i, priorities[i]});
        }
        
        
        int count = 1;
        while(true) {
            int[] current = q.peek();
            
            if (pq.peek() == current[1]) {
                if (current[0] == location) {
                    return count;
                }
                System.out.println(pq.peek() + " " + q.peek() + " " + count);
                pq.poll();
                q.poll();
                count++;
            } else {
                q.offer(q.poll());
            }
        }
    }
}