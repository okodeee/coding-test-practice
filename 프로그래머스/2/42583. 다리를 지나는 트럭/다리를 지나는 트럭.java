import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> truck = new LinkedList<>();
        for (int e : truck_weights) {
            truck.offer(e);
        }
        
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int current_weight = 0; // 다리 위의 트럭 무게 합
        int current_num = 0;    // 다리 위의 트럭 개수
        while (!truck.isEmpty()) {
            int current_truck = truck.peek();
            
            // 하나 빼기
            current_weight -= bridge.poll();
            current_num--;
            
            if (current_num < bridge_length && current_truck + current_weight <= weight) {
                current_num++;
                current_weight += current_truck;
                bridge.offer(current_truck);
                truck.poll();
            } else {
                bridge.offer(0);
            }
            
            answer++;
        }
        
        while(!bridge.isEmpty()) {
            bridge.poll();
            answer++;
        }
        
        return answer;
    }
}