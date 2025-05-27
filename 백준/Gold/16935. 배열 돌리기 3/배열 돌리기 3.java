import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        field = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1: first(); break;
                case 2: second(); break;
                case 3: third(); break;
                case 4: fourth(); break;
                case 5: fifth(); break;
                case 6: sixth(); break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(field[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int swap(int localA, int localB) {
        return localA;
    }

    static void first() {
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N/2; j++) {
                field[j][i] = swap(field[N + 1 - j][i], field[N + 1 - j][i] = field[j][i]);
            }
        }
    }

    static void second() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M/2; j++) {
                field[i][j] = swap(field[i][M + 1 - j], field[i][M + 1 - j] = field[i][j]);
            }
        }
    }

    static void third() {
        int[][] temp = new int[M + 1][N + 1]; // 크기 바뀜: M행 N열

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                temp[j][N - i + 1] = field[i][j]; // 90도 회전
            }
        }

        // 필드 업데이트: temp를 field로 옮기고 N, M 바꿈
        field = new int[M + 1][N + 1];
        int t = N;
        N = M;
        M = t;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                field[i][j] = temp[i][j];
            }
        }
    }

    static void fourth() {
        int[][] temp = new int[M + 1][N + 1]; // 회전 시 크기 바뀜

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                temp[M - j + 1][i] = field[i][j]; // 반시계 회전
            }
        }

        // 필드 업데이트: temp를 field로 옮기고 N, M 바꿈
        field = new int[M + 1][N + 1];
        int t = N;
        N = M;
        M = t;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                field[i][j] = temp[i][j];
            }
        }
    }

    static void fifth() {
        int[][] temp = new int[N/2 + 1][M/2 + 1];
        // 1번 그룹 저장
        for (int i = 1; i <= N/2; i++) {
            for (int j = 1; j <= M/2; j++) {
                temp[i][j] = field[i][j];
            }
        }

        // 4 -> 1
        for (int i = N/2 + 1; i <= N; i++) {
            for (int j = 1; j <= M/2; j++) {
                field[i - N/2][j] = field[i][j];
            }
        }

        // 3 -> 4
        for (int i = N/2 + 1; i <= N; i++) {
            for (int j = M/2 + 1; j <= M; j++) {
                field[i][j - M/2] = field[i][j];
            }
        }

        // 2 -> 3
        for (int i = 1; i <= N/2; i++) {
            for (int j = M/2 + 1; j <= M; j++) {
                field[i + N/2][j] = field[i][j];
            }
        }

        // 1(temp) -> 2
        for (int i = 1; i <= N/2; i++) {
            for (int j = 1; j <= M/2; j++) {
                field[i][j + M/2] = temp[i][j];
            }
        }
    }

    static void sixth() {
        int[][] temp = new int[N/2 + 1][M/2 + 1];
        // 1번 그룹 저장
        for (int i = 1; i <= N/2; i++) {
            for (int j = 1; j <= M/2; j++) {
                temp[i][j] = field[i][j];
            }
        }

        // 2 -> 1
        for (int i = 1; i <= N/2; i++) {
            for (int j = M/2 + 1; j <= M; j++) {
                field[i][j - M/2] = field[i][j];
            }
        }

        // 3 -> 2
        for (int i = N/2 + 1; i <= N; i++) {
            for (int j = M/2 + 1; j <= M; j++) {
                field[i - N/2][j] = field[i][j];
            }
        }

        // 4 -> 3
        for (int i = N/2 + 1; i <= N; i++) {
            for (int j = 1; j <= M/2; j++) {
                field[i][j + M/2] = field[i][j];
            }
        }

        // 1(temp) -> 4
        for (int i = 1; i <= N/2; i++) {
            for (int j = 1; j <= M/2; j++) {
                field[i + N/2][j] = temp[i][j];
            }
        }

    }
}