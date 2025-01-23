import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

// 작은 순서대로 하면 되는 거 아님?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(br.readLine());
            queue.add(cards[i]);
        }

        while(queue.size() > 1) {
            int a = queue.poll() + queue.poll();
            result += a;

            queue.add(a);
        }

        System.out.println(result);
    }
}