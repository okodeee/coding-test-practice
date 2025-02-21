class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        int length = prices.length;
        for (int i = 0; i < length; i++) {
            int count = 0;
            int currentPrice = prices[i];
            for (int j = i + 1; j < length; j++) {
                count++;
                if (prices[j] < currentPrice) break;
            }
            answer[i] = count;
        }
        
        return answer;
    }
}