import java.io.*;
import java.util.*;

/*
 * 시간 초과 해결 (완전탐색 -> BFS)
 * 동시에 퍼지는 시뮬레이션을 구현하기 위해 BFS 사용
 * 큐를 사용하여 같은 시간 내에서 바이러스 퍼짐 순서가 보장됨
 *
 * 우선 순위 큐로 type 비교하면 시간 순서가 섞임
 * -> type, time 모두 비교해주어야함
 */
public class Main {

    static class Virus implements Comparable<Virus> {
        int x, y, type, time;

        Virus(int x, int y, int type, int time) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.time = time;
        }

        @Override
        public int compareTo(Virus o) {
            return Integer.compare(this.type, o.type); // 번호가 낮은 바이러스가 우선
        }
    }

    static int N;
    static int[][] location;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        location = new int[N + 1][N + 1];
        List<Virus> virusList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                location[i][j] = Integer.parseInt(st.nextToken());
                if (location[i][j] != 0) {
                    virusList.add(new Virus(i, j, location[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        Collections.sort(virusList);    // 바이러스 번호 순대로

        Queue<Virus> q = new LinkedList<>(virusList);

        while (!q.isEmpty()) {
            Virus virus = q.poll();

            if (virus.time == S) break;

            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                if (nx > 0 && nx <= N && ny > 0 && ny <= N && location[nx][ny] == 0) {
                    location[nx][ny] = virus.type;
                    q.offer(new Virus(nx, ny, virus.type, virus.time + 1));
                }
            }
        }

        System.out.println(location[targetX][targetY]);
    }
}