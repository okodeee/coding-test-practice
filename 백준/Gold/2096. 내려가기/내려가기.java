import java.io.*;
import java.util.*;

/*
 * 메모리 초과 원인 분석
 * maxScore[N+1][4], minScore[N+1][4] 배열을 선언 → O(N) 메모리 사용
 * 이전 행만 있으면 현재 행을 계산할 수 있음! (O(1) 공간만 필요)
 * 이전 행의 정보만 유지하면 되므로, 1차원 배열(크기 3)만 사용하면 됨!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] maxPrev = new int[3]; // 이전 행의 최대값
        int[] minPrev = new int[3]; // 이전 행의 최소값
        int[] maxCurr = new int[3]; // 현재 행의 최대값
        int[] minCurr = new int[3]; // 현재 행의 최소값

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            maxPrev[i] = minPrev[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            maxCurr[0] = Math.max(maxPrev[0], maxPrev[1]) + a;
            maxCurr[1] = Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]) + b;
            maxCurr[2] = Math.max(maxPrev[1], maxPrev[2]) + c;

            minCurr[0] = Math.min(minPrev[0], minPrev[1]) + a;
            minCurr[1] = Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]) + b;
            minCurr[2] = Math.min(minPrev[1], minPrev[2]) + c;

            // 이전 행을 현재 행으로 갱신
            System.arraycopy(maxCurr, 0, maxPrev, 0, 3);
            System.arraycopy(minCurr, 0, minPrev, 0, 3);
        }

        int maxResult = Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]);
        int minResult = Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]);
        System.out.println(maxResult + " " + minResult);
    }
}
