import java.util.*;
import java.io.*;

class Solution {
    // 단품메뉴 조합, 손님 수
    static Map<String, Integer> combiCount = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        // 각 조합 map 에 저장
        for (String order : orders) {
            int length = order.length();
            
            // 각 자리 넣기/안넣기
            makeCombi(order, length, 0, "");
        }
        
        int[] maxRecom = new int[course.length];
        for (String combi : combiCount.keySet()) {
            for (int i = 0; i < course.length; i++) {
                if (course[i] == combi.length()) {
                    maxRecom[i] = Math.max(maxRecom[i], combiCount.get(combi));
                }
            }
        }
        
        List<String> answer = new ArrayList<>();
        
        for (String combi : combiCount.keySet()) {
            for (int i = 0; i < course.length; i++) {
                if (course[i] == combi.length() && maxRecom[i] > 1 && maxRecom[i] == combiCount.get(combi)) {
                    answer.add(combi);
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
    
    static void makeCombi(String str, int l, int depth, String combi) {
        if (l == depth) {
            char[] charArray = combi.toCharArray();
            Arrays.sort(charArray);
            String sortedCombi = new String(charArray);
            
            combiCount.put(sortedCombi, combiCount.getOrDefault(sortedCombi, 0) + 1);
            return;
        }
        // 해당 자리 넣기
        makeCombi(str, l, depth + 1, combi + str.charAt(depth));
        
        // 해당 자리 안 넣기
        makeCombi(str, l, depth + 1, combi);
    }
}