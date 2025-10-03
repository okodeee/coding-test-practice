import java.util.*;
import java.io.*;

class Solution {
    static int n;
    static int[] apeach;
    static int[] result = new int[] {-1};;
    static int maxScore = 0;
    
    public int[] solution(int n, int[] apeach) {
        this.n = n;
        this.apeach = apeach;
        
        int[] lyan = new int[11];
        backtracking(lyan, 0, 0);
        
        if (maxScore > 0) {
            return result;
        } else {
            return new int[] { -1};
        }
    }
    
    static public void backtracking(int[] lyan, int depth, int usedArrow) {
        if (depth == 11) {
            // 가장 큰 점수 차이 갱신
            lyan[10] += n - usedArrow;
            
            int lyanScore = 0;
            int apeachScore = 0;
            for (int i = 0; i < 11; i++) {
                if (lyan[i] > apeach[i]) {
                    lyanScore += 10 - i;
                } else if (apeach[i] > 0) {
                    apeachScore += 10 - i;
                }
            }
            
            int scoreDiff = lyanScore - apeachScore;
            
            if (scoreDiff > 0) {
                if (scoreDiff > maxScore) {
                    maxScore = scoreDiff;
                    result = lyan.clone();
                } else if (scoreDiff == maxScore) {
                    if (isLowerScoreMore(lyan, result)) {
                        result = lyan.clone();
                    }
                }
            }

            return;
        }
        
        for (int i = n - usedArrow; i >= 0; i--) {  // 해당 점수에 사용한 화살
            int[] arr = lyan.clone();
            arr[depth] = i;
            backtracking(arr, depth + 1, usedArrow + i);
        }
    }
    
    static boolean isLowerScoreMore(int[] lyan, int[] result) {
        // 0점부터 10점까지 역순으로 비교
        for (int i = 10; i >= 0; i--) {
            if (lyan[i] > result[i]) return true;
            if (lyan[i] < result[i]) return false;
        }
        return false;  // 완전히 같으면 기존 것 유지
    }
}