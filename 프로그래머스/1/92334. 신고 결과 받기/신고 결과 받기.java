import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 몇 번째 이용자인지 indexOf 사용하도록 리스트로 변경
        List<String> idList = Arrays.asList(id_list);
        
        // 1. 각 유저 별로 몇 번 신고 당했는지 저장
        int[] countReport = new int[id_list.length];
        
        // 동시에 신고당한 유저에 대해 누가 신고했는지 저장해두기        
        // 어떤 유저에 대해 신고한 유저들이 누구인지
        List<String>[] reporters = new ArrayList[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            reporters[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < report.length; i++) {
            String[] st = report[i].split(" ");
            String reporter = st[0];
            String reportee = st[1];
            
            // 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
            if (reporters[idList.indexOf(reportee)].indexOf(reporter) >= 0) continue;
            
            countReport[idList.indexOf(reportee)]++;
            reporters[idList.indexOf(reportee)].add(reporter);
        }
        
        // 2. k번 이상 신고를 당한 유저를 신고한 유저별 정지 몇 명 됐는지 계산
        for (int i = 0; i < id_list.length; i++) {
            if (countReport[i] >= k) {
                for (String reporter : reporters[i]) {
                    answer[idList.indexOf(reporter)]++;
                }
            }
        }
        
        return answer;  // 각 유저별로 처리 결과 메일을 받은 횟수
    }
}