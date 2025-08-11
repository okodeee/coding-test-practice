import java.io.*;
import java.util.*;

/*
 * 중위 순회 배열에서 가운데 원소가 서브트리의 루트
 */
public class Main {
    static List<Integer>[] levels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        levels = new List[K + 1];
        for (int i = 1; i <= K; i++) {
            levels[i] =  new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input =  new int[(int) Math.pow(2, K)];
        for (int i = 1; i < Math.pow(2, K); i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        buildTree(input, 1, input.length - 1, 1);

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < levels[i].size(); j++) {
                System.out.print(levels[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    static void buildTree(int[] inorder, int start, int end, int level) {
        if (start > end) return;

        int mid = (start + end) / 2;  // 루트 위치
        int root = inorder[mid];      // 루트 값

        // 현재 레벨에 루트 추가
        levels[level].add(root);

        // 왼쪽, 오른쪽 서브트리 재귀 처리
        buildTree(inorder, start, mid-1, level+1);    // 왼쪽 먼저
        buildTree(inorder, mid+1, end, level+1);      // 오른쪽 나중에
    }
}