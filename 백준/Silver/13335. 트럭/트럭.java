import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 트럭 수
        int W = Integer.parseInt(st.nextToken());   // 다리 길이
        int L = Integer.parseInt(st.nextToken());   // 최대 하중

        // 다리 길이 만큼 큐에 0 추가
        Queue<Integer> bridge = new LinkedList<Integer>();
        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }

        // 초기화
        int time = 0;
        int sum = 0;    // 다리 위에 있는 트럭 무게 합

        st = new StringTokenizer(br.readLine());
        int truck = Integer.parseInt(st.nextToken());

        while (true) { // 더 이상 넣을 트럭이 없을 때까지 반복
            time++;

            sum -= bridge.remove();
            if (sum + truck <= L) { // 새로운 트럭이 다리를 건널 수 있을 때
                bridge.add(truck);
                sum += truck;
                if (--N == 0) break;
                truck = Integer.parseInt(st.nextToken());
            } else {
                bridge.add(0);
            }
        }

        time += bridge.size();  // 다리에 남아있는 트럭들 건너는 시간 추가
        System.out.println(time);
    }
}