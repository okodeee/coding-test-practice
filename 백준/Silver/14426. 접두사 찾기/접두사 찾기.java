import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 모든 가능한 접두사를 미리 생성하여 저장
        Set<String> prefixSet = new HashSet<>();
        
        for (int i = 0 ; i < N; i++) {
            String word = br.readLine();
            
            for (int j = 1; j <= word.length(); j++) {
                prefixSet.add(word.substring(0, j));
            }
        }
        
        int count = 0;
        
        // 각 검사 문자열이 접두사 Set에 있는지 확인
        for (int i = 0; i < M; i++) {
            String target = br.readLine();
            if (prefixSet.contains(target)) {   // O(1) 검색
                count++;
            }
        }        

        System.out.println(count);
    }
}