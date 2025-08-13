import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] children;    // 각 노드의 자식들을 저장하는 배열
    static boolean[] deleted;           // 삭제된 노드를 표시하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        children = new List[N];
        for (int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;  // 루트 노드 저장
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                children[parent].add(i);
            }
        }

        int deleteNode = Integer.parseInt(br.readLine());

        deleted = new boolean[N];

        // 삭제할 노드와 그 자손들 삭제 처리
        markDeleted(deleteNode);

        int leafCount = countLeaves(root);
        System.out.println(leafCount);
    }

    static void markDeleted(int node) {
        deleted[node] = true;
        for (int i = 0; i < children[node].size(); i++) {
            markDeleted(children[node].get(i));
        }
    }

    static int countLeaves(int node) {
        if (deleted[node]) {
            return 0;
        }

        int aliveChildren = 0;
        int totalLeaves = 0;

        for (int child : children[node]) {
            if (!deleted[child]) {
                aliveChildren++;
                totalLeaves += countLeaves(child);
            }
        }

        // 살아있는 자식이 없다면 현재 노드가 리프 노드
        if (aliveChildren == 0) {
            return 1;
        } else {
            return totalLeaves;
        }
    }
}