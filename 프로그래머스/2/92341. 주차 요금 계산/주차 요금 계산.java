import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        // 1. 자동차 별 누적 주차 시간 계산
        Map<Integer, Integer> timeSum = new HashMap<>();    // 누적 주차 시간
        Map<Integer, Integer> startTime = new HashMap<>();  // 입차 시간('분' 단위)
        
        for (String record : records) {
            String[] st = record.split(" ");
            String[] time = st[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            int carNum = Integer.parseInt(st[1]);
            
            // Java에서 ==는 객체의 주소를 비교하는 연산자
            if (st[2].equals("IN")) {    // 입차 처리 (startTime에 입차 시간 저장)
                startTime.put(carNum, hour * 60 + minute);
            } else {    // 출차 처리 (startTime 입차 시간과 출차 시간 계산해서 누적 값 처리)
                timeSum.put(carNum, timeSum.getOrDefault(carNum, 0) + hour * 60 + minute - startTime.get(carNum));
                startTime.remove(carNum);
            }
        }
        
        // 1-1. 어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주
        for(int carNum : startTime.keySet()) {
            timeSum.put(carNum, timeSum.getOrDefault(carNum, 0) + 23 * 60 + 59 - startTime.get(carNum));
        }
        
        // 2. 자동차 별 주차 요금 계산
        List<Integer> cars = new ArrayList<>(timeSum.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        int cumulativeTime = 0;
        for (int i = 0; i < cars.size(); i++) {
            cumulativeTime = timeSum.get(cars.get(i));
            if (fees[0] > cumulativeTime) {
                answer[i] = fees[1];
            } else {
                answer[i] = fees[1];
                cumulativeTime -= fees[0];
                answer[i] += (cumulativeTime / fees[2] * fees[3]);
                if (cumulativeTime % fees[2] > 0) answer[i] += fees[3];
            }
        }
        
        return answer;
    }
}