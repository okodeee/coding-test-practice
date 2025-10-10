import java.util.*;
import java.io.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        int deliveryBox = 0;
        int pickupBox = 0;
        for (int i = 0; i < n; i++) {
            deliveryBox += deliveries[i];
            pickupBox += pickups[i];
        }
        
        long answer = 0;
        int furthestHouse = n - 1;
        int furthestDelivery = n - 1;
        int furthestPickup = n - 1;
        while (deliveryBox > 0 || pickupBox > 0) {
            while (furthestDelivery >= 0 && deliveries[furthestDelivery] == 0) {
                furthestDelivery--;
            }
            while (furthestPickup >= 0 && pickups[furthestPickup] == 0) {
                furthestPickup--;
            }
            
            furthestHouse = Math.max(furthestDelivery, furthestPickup);
            answer += furthestHouse + 1;
            int currentDelivery = cap;
            int currentPickup = cap;
            
            // 가장 먼 곳부터 cap 만큼 배달
            while (currentDelivery > 0 && furthestDelivery >= 0) {
                if (deliveries[furthestDelivery] > 0) {
                    deliveries[furthestDelivery]--;
                    currentDelivery--;
                    deliveryBox--;
                    
                } else {
                    furthestDelivery--;
                }
            }
            
            // 가장 먼 곳부터 cap 만큼 수거
            while (currentPickup > 0 && furthestPickup >= 0) {
                if (pickups[furthestPickup] > 0) {
                    pickups[furthestPickup]--;
                    currentPickup--;
                    pickupBox--;
                } else {
                    furthestPickup--;
                }
            }
        }
        
        return answer * 2;
    }
}