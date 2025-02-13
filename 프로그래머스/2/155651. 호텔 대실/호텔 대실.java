import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2];
        for(int i = 0 ; i < book_time.length ; i++){
            String[] startTime = book_time[i][0].split(":");
            String[] endTime = book_time[i][1].split(":");
            time[i][0] = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            time[i][1] = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]) + 10;
        }
        
        Arrays.sort(time, (a, b) -> (a[0] - b[0]));
        
        int answer = 0;
        int rooms = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < time.length; i++) {
            int checkIn = time[i][0];
            while(!pq.isEmpty() && pq.peek().compareTo(checkIn) <= 0 ) {
                pq.poll();
                rooms--;
            }
            
            pq.add(time[i][1]);
            rooms++;
            
            answer = Math.max(answer, rooms);
        }

        return answer;
    }
}