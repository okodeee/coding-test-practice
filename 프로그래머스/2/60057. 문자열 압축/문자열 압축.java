class Solution {
    public int solution(String s) {
        int answer = s.length(); // 최악의 경우 = 원본 길이

        // 1. 모든 단위를 시도해보기
        for (int unit = 1; unit <= s.length() / 2; unit++) {
    
            // 2. 현재 단위로 압축하기
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, unit); // 첫 번째 조각
            int count = 1;
    
            // 3. 문자열을 단위별로 잘라가며 비교
            for (int i = unit; i < s.length(); i += unit) {
                String current = s.substring(i, Math.min(i+unit, s.length()));
        
                if (prev.equals(current)) {
                    count++; // 같으면 카운트 증가
                } else {
                    // 다르면 결과에 추가
                    if (count > 1) compressed.append(count);
                    compressed.append(prev);
            
                    prev = current;
                    count = 1;
                }
            }
    
            // 4. 마지막 조각 처리
            if (count > 1) compressed.append(count);
            compressed.append(prev);
    
            // 5. 최소 길이 갱신
            answer = Math.min(answer, compressed.length());
        }
        
        return answer;
    }
}