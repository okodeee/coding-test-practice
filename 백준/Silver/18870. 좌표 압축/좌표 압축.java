import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];  // 원본 순서를 유지할 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> uniqueSet = new HashSet<>();  // 중복 제거용 Set

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            uniqueSet.add(input[i]);  // 중복 제거
        }

        // 중복 제거된 값을 정렬
        List<Integer> sortedUniqueList = new ArrayList<>(uniqueSet);
        Collections.sort(sortedUniqueList);  // O(N log N)

        // 정렬된 리스트에서 각 값의 인덱스를 해시맵에 저장 (O(N))
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < sortedUniqueList.size(); i++) {
            indexMap.put(sortedUniqueList.get(i), i);
        }

        // 원본 배열을 순회하며 인덱스를 찾고 결과 생성 (O(N))
        for (int i = 0; i < N; i++) {
            sb.append(indexMap.get(input[i])).append(' ');
        }
        
        System.out.println(sb);
    }
}
