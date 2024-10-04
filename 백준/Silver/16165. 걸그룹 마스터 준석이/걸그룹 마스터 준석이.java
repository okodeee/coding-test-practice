import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // (key : value)
        HashMap<String, String[]> map1 = new HashMap<>();   // (team : members)
        HashMap<String, String> map2 = new HashMap<>();   // (member : team)

        String team, member;
        Integer num;
        String[] members;
        for (int i = 0; i < N; i++) {
            team = br.readLine();
            num = Integer.parseInt(br.readLine());
            members = new String[num];
            for (int j = 0; j < num; j++) {
                member = br.readLine();
                map2.put(member, team);
                members[j] = member;
            }
            Arrays.sort(members);
            map1.put(team, members);
        }

        String q;
        int type;
        for (int i = 0; i < M; i++) {
            q = br.readLine();
            type = Integer.parseInt(br.readLine());
            if (type == 0) {
                members = map1.get(q);
                for (String m : members)
                    System.out.println(m);
            } else {
                System.out.println(map2.get(q));
            }
        }
    }
}