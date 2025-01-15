import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] stats;
    static boolean[] isVisited;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stats = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹 시작
        divideTeams(1, 0);

        System.out.println(minDifference);
    }

    // 백트래킹: 팀 나누기
    public static void divideTeams(int idx, int cnt) {
        // 종료 조건: 한 팀이 절반 인원을 채웠을 때
        if (cnt == N / 2) {
            calculateDifference();
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true; // 선택
                divideTeams(i + 1, cnt + 1); // 재귀 호출
                isVisited[i] = false; // 백트래킹 (원상복구)
            }
        }
    }

    // 팀 능력치 차이 계산
    static void calculateDifference() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (isVisited[i] && isVisited[j]) {
                    startTeam += stats[i][j]; // 스타트 팀 능력치 계산
                } else if (!isVisited[i] && !isVisited[j]) {
                    linkTeam += stats[i][j]; // 링크 팀 능력치 계산
                }
            }
        }

        // 능력치 차이 계산
        int difference = Math.abs(startTeam - linkTeam);

        // 최소 차이 갱신
        minDifference = Math.min(minDifference, difference);
    }
}