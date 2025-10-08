import java.util.*;
import java.io.*;

class Solution {
    static int[] info;
    static List<Integer>[] graph;
    static int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        graph = new List[info.length];
        
        for (int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        
        List<Integer> nextNode = new ArrayList<>();
        nextNode.add(0);
        
        dfs(0, 0, 0, nextNode);
        
        return answer;
    }
    
    static void dfs(int node, int sheep, int wolf, List<Integer> nextNode) {        
        sheep += info[node] ^ 1;
        wolf += info[node];
        
        if (sheep <= wolf) return;
        
        answer = Math.max(answer, sheep);
        
        List<Integer> newNextNode = new ArrayList<>(nextNode);
        newNextNode.remove(Integer.valueOf(node));
        
        for (int child : graph[node]) {
            newNextNode.add(child);
        }
        
        for (int next : newNextNode) {
            // 각 경로마다 독립적인 방문 가능 리스트 전달
            dfs(next, sheep, wolf, newNextNode);
        }
    }
}