import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> personality = new HashMap<>();
        for (int i = 0; i < survey.length; i++) {
            String currentSurvey = survey[i];
            int currentChoice = choices[i];
            if (currentChoice == 1) {
                char ele = currentSurvey.charAt(0);
                personality.put(ele, personality.getOrDefault(ele, 0) + 3);
            } else if (currentChoice == 2) {
                char ele = currentSurvey.charAt(0);
                personality.put(ele, personality.getOrDefault(ele, 0) + 2);
            } else if (currentChoice == 3) {
                char ele = currentSurvey.charAt(0);
                personality.put(ele, personality.getOrDefault(ele, 0) + 1);
            } else if (currentChoice == 5) {
                char ele = currentSurvey.charAt(1);
                personality.put(ele, personality.getOrDefault(ele, 0) + 1);
            } else if (currentChoice == 6) {
                char ele = currentSurvey.charAt(1);
                personality.put(ele, personality.getOrDefault(ele, 0) + 2);
            } else if (currentChoice == 7) {
                char ele = currentSurvey.charAt(1);
                personality.put(ele, personality.getOrDefault(ele, 0) + 3);
            } 
        }
        
        if (personality.getOrDefault('R', 0) >= personality.getOrDefault('T', 0)) {
            answer += 'R';
        } else {
            answer += 'T';
        }
        
        if (personality.getOrDefault('C', 0) >= personality.getOrDefault('F', 0)) {
            answer += 'C';
        } else {
            answer += 'F';
        }
        
        if (personality.getOrDefault('J', 0) >= personality.getOrDefault('M', 0)) {
            answer += 'J';
        } else {
            answer += 'M';
        }
        
        if (personality.getOrDefault('A', 0) >= personality.getOrDefault('N', 0)) {
            answer += 'A';
        } else {
            answer += 'N';
        }
        
        return answer;
    }
}