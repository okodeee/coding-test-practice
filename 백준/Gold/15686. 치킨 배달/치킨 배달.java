import java.io.*;
import java.util.*;

public class Main {
    static int N, M, minCityDistance = Integer.MAX_VALUE;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int[][] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];

        // 도시 정보 입력 및 집과 치킨집 위치 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) houses.add(new int[]{i, j});
                if (city[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }

        // 치킨집 중 M개를 선택하는 조합 생성
        selectChickens(0, new ArrayList<>());
        System.out.println(minCityDistance);
    }

    // 치킨집 M개 선택하는 조합 (백트래킹)
    static void selectChickens(int start, List<int[]> selected) {
        if (selected.size() == M) {
            minCityDistance = Math.min(minCityDistance, calculateCityDistance(selected));
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            selectChickens(i + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    // 선택된 M개의 치킨집으로 도시의 치킨 거리 계산
    static int calculateCityDistance(List<int[]> selectedChickens) {
        int cityDistance = 0;
        
        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int[] chicken : selectedChickens) {
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDistance = Math.min(minDistance, distance);
            }
            cityDistance += minDistance;
        }
        return cityDistance;
    }
}
