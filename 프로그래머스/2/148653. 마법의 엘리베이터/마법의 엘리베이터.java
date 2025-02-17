import java.io.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int last = storey % 10;
            
            if (last < 5) {
                answer += last;  // (-)로 이동
            } else if (last > 5) {
                answer += (10 - last);  // (+)로 이동
                storey += (10 - last);
            } else {    // 5인 경우 다음 자릿수로 판단해야함
                int next = (storey / 10) % 10;
                if (next >= 5) {
                    answer += (10 - last);
                    storey += (10 - last);
                } else {
                    answer += last;
                }
            }
            storey /= 10;
        }
        
        return answer;
    }
}