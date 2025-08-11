import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] relation = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                relation[i][j] = 10000;
            }
        }

        // 친구 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a][b] = relation[b][a] = 1;
        }

        // 플로이드-워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    relation[i][j] = Math.min(relation[i][j], relation[i][k] + relation[k][j]);
                }
            }
        }

        int minKevin = 10000;
        int result = 1;
        for (int i = 1; i <= N; i++) {
            int Kevin = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                Kevin += relation[i][j];
            }
            if (minKevin > Kevin) {
                minKevin = Kevin;
                result = i;
            }
        }

        System.out.println(result);
    }
}