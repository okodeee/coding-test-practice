import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // 약관 종류를 배열로 저장
        int[] termsSort = new int[26];
        for (String term : terms) {
            String[] sp = term.split(" ");
            termsSort[sp[0].charAt(0) - 'A'] = Integer.parseInt(sp[1]);
        }
        
        // 개인정보 순회하며 파기해야 할 번호 찾기
        String[] sp = today.split("\\.");
            // 달 기준으로 계산
        int todayMon = Integer.parseInt(sp[0]) * 12 + Integer.parseInt(sp[1]);
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] sp1 = privacies[i].split(" ");
            String[] sp2 = sp1[0].split("\\.");
            
            int date = Integer.parseInt(sp2[0]) * 12 + Integer.parseInt(sp2[1]);
            int expirationDate = date + termsSort[sp1[1].charAt(0) - 'A'];
            
            if (todayMon > expirationDate) {
                answer.add(i + 1);
            } else if (todayMon == expirationDate) {
                if (Integer.parseInt(sp2[2]) <= Integer.parseInt(sp[2])) {
                    answer.add(i + 1);
                }
            }
        }
        
        int[] answerArray = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArray[i] = answer.get(i);
        }
        
        return answerArray;
    }
}