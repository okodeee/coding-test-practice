import java.util.*;
import java.io.*;

class Solution {
    public String solution(String p) {
        return process(p);
    }
    
    static String process(String str) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환
        if (str.isEmpty()) return str;
        
        // 2. u랑 v로 분리
        int leftNum = 0;
        int rightNum = 0;
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch == '(') {
                leftNum++;
            } else {
                rightNum++;
            }
            
            u.append(ch);
            
            // u는 "균형잡힌 괄호 문자열"
            if (leftNum == rightNum) {
                v.append(str.substring(i + 1));
                break;
            }
        }
        
        if (isValid(u.toString())) {   // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
            return u + process(v.toString());
        } else {    // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(process(v.toString())).append(")");
            
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    sb.append(")");
                } else {
                    sb.append("(");
                }
            }
            
            return sb.toString();
        }
    }
    
    static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
                
            }
        }
        
        if (!stack.isEmpty()) return false;
        return true;
    }
}