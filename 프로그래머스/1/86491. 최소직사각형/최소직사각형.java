import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        int maxWidth = 1;
        int maxHeight = 1;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > maxWidth) maxWidth = sizes[i][0];
            if (sizes[i][1] > maxHeight) maxHeight = sizes[i][1];
        }
        
        answer = maxWidth * maxHeight;
        
        return answer;
    }
}