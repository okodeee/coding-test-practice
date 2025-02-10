import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        Collection<Integer> values = map.values();
        int answer = 1;
        for (int e : values) {
            answer *= e + 1;
        }
        
        return answer - 1;
    }
}