import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> posQueue = new PriorityQueue<>();
        PriorityQueue<Integer> negQueue = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());

            if (val == 0) {
                if (negQueue.isEmpty() && posQueue.isEmpty()) {
                    System.out.println("0");
                } else if (negQueue.isEmpty()) {
                    System.out.println(posQueue.poll());
                } else if (posQueue.isEmpty()) {
                    System.out.println(negQueue.poll());
                } else {
                    if (posQueue.peek() < -negQueue.peek()) {
                        System.out.println(posQueue.poll());
                    } else {
                        System.out.println(negQueue.poll());
                    }
                }
            } else {
                if ((val > 0)) {
                    posQueue.add(val);
                } else {
                    negQueue.add(val);
                }
            }
        }
    }
}