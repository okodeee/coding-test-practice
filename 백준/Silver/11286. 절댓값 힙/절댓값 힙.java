import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //절대값 기준으로 앞 값이 더 크다면 자리를 바꿔준다.
                if(Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                    //절대값 기준으로 두 값이 같다면 음수를 앞으로 보내준다.
                }else if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }else {
                    return -1;
                }
            }
        });
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());

            if (val == 0) {
                if (queue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(queue.poll()).append('\n');
                }
            } else {
                queue.add(val);
            }
        }

        System.out.println(sb);
    }
}