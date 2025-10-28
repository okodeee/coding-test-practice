import java.io.*;
import java.util.*;

public class Main {
    static int[] team;  // 각 사람의 팀 번호
    static List<Integer>[] hate;    // 각 사람들이 싫어하는 사람 목록

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        hate = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            hate[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                int p = Integer.parseInt(st.nextToken());
                if (!hate[i].contains(p)) {
                    hate[i].add(p);
                }
                if (!hate[p].contains(i)) {
                    hate[p].add(i);
                }
            }
        }

        // 팀 나누기
        team = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            if (team[i] == 0) {
                setTeam(i);
            }
        }

        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (team[i] == 1) {
                team1.add(i);
            } else {
                team2.add(i);
            }
        }
        Collections.sort(team1);
        Collections.sort(team2);

        StringBuilder sb = new StringBuilder();
        sb.append(team1.size()).append('\n');
        for (int p : team1) {
            sb.append(p).append(" ");
        }
        sb.append('\n').append(team2.size()).append('\n');
        for (int p : team2) {
            sb.append(p).append(" ");
        }
        System.out.println(sb);
    }

    static void setTeam(int num) {
        Queue<Integer> q = new LinkedList<>();

        team[num] = 1;
        q.add(num);

        while(!q.isEmpty()) {
            int curr = q.poll();
            int oppoTeam = 3 - team[curr]; // 반대팀

            for (int p : hate[curr]) {
                if (team[p] == 0) {
                    team[p] = oppoTeam;
                    q.add(p);
                }
            }
        }

    }
}