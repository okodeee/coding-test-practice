import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
            });

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = 0;
            while (num > 0) {
                if (num % 2 == 1) count++;
                num /= 2;
            }

            pq.offer(new int[] { arr[i], count });
        }

        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = pq.poll()[0];
        }

        return answer;
    }
}