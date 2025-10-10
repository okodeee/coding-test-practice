import java.util.*;
import java.io.*;

class Solution {
    static int[][] users;
    static int[] emoticons;
    static int plusSubscriberAnswer = 0;
    static int takeAnswer = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        
        dfs(0, new int[emoticons.length]);
        
        return new int[] { plusSubscriberAnswer, takeAnswer };
    }
    
    // 할인비율 별 플러스가입자수와 매출액 구하기
    static void dfs(int depth, int[] eachRate) {
        if (depth == emoticons.length) {
            int plusSubscriber = 0;
            int take = 0;
        
            int userCost = 0;
            for (int i = 0; i < users.length; i++) {    // i번째 유저
                userCost = cost(eachRate, i);
            
                if (userCost >= users[i][1]) {  // 플러스 서비스 가입
                    plusSubscriber++;
                } else {
                    take += userCost;
                }
            }
        
            // 목표에 맞게 최댓값 갱신
            if (plusSubscriber > plusSubscriberAnswer) {
                plusSubscriberAnswer = plusSubscriber;
                takeAnswer = take;
            } else if (plusSubscriber == plusSubscriberAnswer) {
                if (take > takeAnswer) {
                    takeAnswer = take;
                }
            }
            
            

            return;
        }
        
        for (int rate = 10; rate <= 40; rate += 10) {   // 할인율은 10, 20, 30, 40
            int[] newEachRate = eachRate.clone();
            newEachRate[depth] = rate;
            dfs(depth + 1, newEachRate);
        }
    }
    
    // 각 사용자별 이모티콘 구매 비용 구하기 (플러스 서비스 고려X)
    static int cost(int[] eachRate, int user) {
        int cost = 0;
        int userRate = users[user][0];
        
        for (int i = 0; i < eachRate.length; i++) { // i 번째 이모티콘
            if (eachRate[i] >= userRate) {  // 할인율이 더 크면 구매
                cost += emoticons[i] - (emoticons[i] * eachRate[i] / 100);
            } 
        }
        
        return cost;
    }
    
    static void printRate(int[] rates) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < rates.length; i++) {
            sb.append(rates[i]).append(" ");
        }
        System.out.println(sb);
    }
}