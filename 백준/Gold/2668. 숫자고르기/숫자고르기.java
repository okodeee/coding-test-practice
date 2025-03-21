import java.io.*;
import java.util.*;

/*
 * 그래프 탐색 & 사이클 찾기 문제 판단
 * 1. 주어진 문제를 그래프 구조로 변환할 수 있는가?
 * 2. 사이클이 발생하는지 확인할 수 있는가?
 * 3. DFS/BFS를 활용하여 사이클을 찾을 수 있는가?
 */
public class Main {
    static int N;
    static int[] nums;
    static boolean[] isVisited;
    static List<Integer> result = new ArrayList<>();
    // 답은 가변적이므로 리스트로 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                dfs(i, new ArrayList<>());
            }
        }

        // 결과 정렬 후 출력
        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    static void dfs(int start, List<Integer> path) {
        if (isVisited[start]) {
            // 사이클이 발생하면 사이클에 포함된 숫자만 저장
            if (path.contains(start)) {
                int idx = path.indexOf(start);
                for (int i = idx; i < path.size(); i++) {
                    result.add(path.get(i));
                }
            }
            return;
        }

        isVisited[start] = true;
        path.add(start);

        dfs(nums[start], path);
    }
}