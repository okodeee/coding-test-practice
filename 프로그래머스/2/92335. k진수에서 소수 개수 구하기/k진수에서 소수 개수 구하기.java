import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k) {
        
        // 1. k진수 변환 과정
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String st = sb.reverse().toString();
        
        String[] sp = st.split("0+");
        
        // 배열의 크기가 너무 커서 에라테스테네스 체 사용 불가
        int answer = 0;
        for (String prime : sp) {
            long number = Long.parseLong(prime);
            
            if (number < 2) continue;   // 1은 소수 아님
            
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime) answer++;
        }
        
        return answer;
    }
}