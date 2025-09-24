import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1};

    static class Fireball {
        int r, c, m, s, d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Fireball>[][] field = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                field[i][j] = new ArrayList<Fireball>();
            }
        }
        Queue<Fireball> queue = new LinkedList<>();

        int r, c, m, s, d;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            queue.offer(new Fireball(r, c, m, s, d));
        }

        while (K-- > 0) {
            // 큐 기반으로 이동해서 필드에 넣기
            while(!queue.isEmpty()) {
                Fireball f = queue.poll();
                int nx = (f.r + dx[f.d] * f.s % N + N) % N;
                int ny = (f.c + dy[f.d] * f.s % N + N) % N;
                field[nx][ny].add(new Fireball(nx, ny, f.m, f.s, f.d));
            }

//            printField(field, N);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int cnt = field[i][j].size();

                    // 파이어볼이 1개 이하면 합치기 과정 생략
                    if (cnt < 2) {
                        for (Fireball f : field[i][j]) {
                            queue.offer(f);
                        }
                        field[i][j].clear();
                        continue;
                    }

                    int nm = 0;
                    int ns = 0;

                    boolean isOddOrEven = true;
                    int firstParity = field[i][j].get(0).d % 2;

                    for (Fireball f : field[i][j]) {
                        nm += f.m;
                        ns += f.s;

                        // 모든 파이어볼과 첫 번째 홀짝성 비교
                        if (f.d % 2 != firstParity) {
                            isOddOrEven = false;
                        }
                    }
                    nm /= 5;
                    ns /= cnt;

                    // 질량이 0인 파이어볼 소멸
                    if (nm == 0) {
                        field[i][j].clear();
                        continue;
                    }

                    if (isOddOrEven) {
                        queue.offer(new Fireball(i, j, nm, ns, 0));
                        queue.offer(new Fireball(i, j, nm, ns, 2));
                        queue.offer(new Fireball(i, j, nm, ns, 4));
                        queue.offer(new Fireball(i, j, nm, ns, 6));
                    } else {
                        queue.offer(new Fireball(i, j, nm, ns, 1));
                        queue.offer(new Fireball(i, j, nm, ns, 3));
                        queue.offer(new Fireball(i, j, nm, ns, 5));
                        queue.offer(new Fireball(i, j, nm, ns, 7));
                    }

                    field[i][j].clear();
                }
            }
        }

        int result = 0;
        while(!queue.isEmpty()) {
            Fireball f = queue.poll();
            result += f.m;
        }

        System.out.println(result);
    }

    public static void printField(List<Fireball>[][] field, int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(field[i][j].size()).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}