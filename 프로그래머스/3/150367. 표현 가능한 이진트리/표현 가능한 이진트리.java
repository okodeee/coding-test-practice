import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(long[] numbers) {
        
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            // 1. 주어진 수를 2진법으로 변환
            Long number = numbers[i];
            List<Integer> binary = new ArrayList<>();
            while (number > 0) {
                binary.add(Long.valueOf(number % 2).intValue());
                number /= 2;
            }
            
            List<Integer> isFull = List.of(1, 3, 7, 15, 31, 63);
            // 1-1. 포화이진트리 될 때까지 0 추가하기
            while (!isFull.contains(binary.size())) {
                binary.add(0);
            }
            Collections.reverse(binary);
            
            // 2. 더미 노드의 자식 노드는 모두 더미 노드여야함
            boolean valid = checkTree(binary, 0, binary.size() - 1, false);
            
            if (valid) {
                answer[i] = 1;
            }
        }
        
        return answer;
    }
    
    // 재귀적으로 이진트리가 유효한지 검사
    private boolean checkTree(List<Integer> binary, int start, int end, boolean parentIsDummy) {
        // 더 이상 검사할 노드가 없음
        if (start > end) {
            return true;
        }
        
        // 현재 서브트리의 루트는 중간 지점 (중위 순회 방식)
        int mid = (start + end) / 2;
        int rootValue = binary.get(mid);
        
        // 핵심 규칙: 부모가 더미(0)인데 현재 노드가 1이면 불가능
        if (parentIsDummy && rootValue == 1) {
            return false;
        }
        
        // 왼쪽 서브트리 검사 (start ~ mid-1)
        boolean leftValid = checkTree(binary, start, mid - 1, (rootValue == 0));
        
        // 오른쪽 서브트리 검사 (mid+1 ~ end)
        boolean rightValid = checkTree(binary, mid + 1, end, (rootValue == 0));
        
        // 왼쪽과 오른쪽 모두 유효해야 함
        return leftValid && rightValid;
    }
}