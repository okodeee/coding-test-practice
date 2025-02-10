class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int h = 3; h <= total / h; h++) { // h는 최소 3부터 시작
            if (total % h == 0) {
                int w = total / h;
                if ((w - 2) * (h - 2) == yellow) { // 노란색 개수 검증
                    return new int[]{w, h};
                }
            }
        }
        return null; // 실행되지 않음
    }
}
