import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static boolean[] truthKnown; // 진실을 아는 그룹 표시

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        truthKnown = new boolean[N + 1];

        // 유니온-파인드 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i; // 처음에는 자기 자신이 부모
        }

        // 진실을 아는 사람 정보 입력
        st = new StringTokenizer(br.readLine());
        int numTruth = Integer.parseInt(st.nextToken());

        Set<Integer> truthSet = new HashSet<>();
        if (numTruth > 0) {
            for (int i = 0; i < numTruth; i++) {
                int person = Integer.parseInt(st.nextToken());
                truthSet.add(person);
                truthKnown[person] = true;
            }
        }

        // 각 파티 정보를 저장할 리스트
        List<List<Integer>> parties = new ArrayList<>();

        // 파티 정보 입력 및 유니온 연산 (최종적으로 진실을 아는 사람)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int numPeople = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();
            int firstPerson = Integer.parseInt(st.nextToken());
            party.add(firstPerson);

            for (int j = 1; j < numPeople; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.add(person);
                union(firstPerson, person); // 같은 파티 사람들은 같은 집합으로
            }

            parties.add(party);
        }

        // 진실을 아는 사람들을 하나의 그룹으로 묶음 (한 번 더 업데이트 필요)
        int truthRoot = -1;
        for (int person : truthSet) {
            if (truthRoot == -1) {
                truthRoot = find(person);
            } else {
                union(truthRoot, person);
            }
        }

        // 진실을 아는 그룹을 최종적으로 갱신 (경로 압축을 위해 find 호출)
        for (int person : truthSet) {
            truthKnown[find(person)] = true;
        }

        // 거짓말 가능 파티 개수 계산
        int count = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (truthKnown[find(person)]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) count++;
        }

        System.out.println(count);
    }

    // 유니온 파인드 - 부모 찾기 (경로 압축)
    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    // 유니온 파인드 - 합집합 연산
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}
