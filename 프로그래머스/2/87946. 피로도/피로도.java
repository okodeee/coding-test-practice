import java.util.*;

class Solution {
    private int answer = 0;
    private boolean[] isVisited;
    private int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        isVisited = new boolean[dungeons.length];
        
        counting(k, 0);
        
        return answer;
    }
    
    private void counting(int k, int count) {
        if (count > answer) {
            answer = count;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i] && k >= dungeons[i][0]) {
                isVisited[i] = true;
                counting(k - dungeons[i][1], count + 1);
                isVisited[i] = false;
            }
        }
    }
}