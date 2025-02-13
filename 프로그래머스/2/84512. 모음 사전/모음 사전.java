class Solution {
    public int solution(String word) {
        int[] cnts = { 781, 156, 31, 6, 1 };
        
        int answer = 0;
        int diff;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'A') {
                diff = 0;
            } else if (word.charAt(i) == 'E') {
                diff = 1;
            } else if (word.charAt(i) == 'I') {
                diff = 2;
            } else if (word.charAt(i) == 'O') {
                diff = 3;
            } else {
                diff = 4;
            }
            answer += diff * cnts[i] + 1;
        }
        return answer;
    }
}