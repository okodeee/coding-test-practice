import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];

        // 1. 숫자를 문자열로 변환
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 2. 커스텀 정렬 (내림차순, "XY" vs "YX" 비교)
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        // 3. "0"만 포함된 경우 예외 처리
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        // 4. 정렬된 문자열 연결
        return String.join("", strNumbers);
    }
}
