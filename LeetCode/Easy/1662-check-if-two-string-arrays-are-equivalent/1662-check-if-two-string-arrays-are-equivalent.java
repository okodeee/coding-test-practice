import java.util.*;

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }

        for (int i = 0; i < word2.length; i++) {
            sb2.append(word2[i]);
        }

        // StringBuilder 클래스의 equals() 메서드는 참조하고 있는 주소 값을 비교
        // StringBuilder 객체에서 toString() 메서드를 호출하여 문자열 값으로 변환 후 equals() 메서드를 사용
        if (sb1.toString().equals(sb2.toString())) {
            return true;
        }

        return false;
    }
}