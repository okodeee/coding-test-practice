import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashMap<Integer, Integer> sort = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sort.put(nums[i], sort.getOrDefault(nums[i], 0) + 1);
        }
        
        int answer = Math.min(sort.size(), nums.length / 2);
        return answer;
    }
}