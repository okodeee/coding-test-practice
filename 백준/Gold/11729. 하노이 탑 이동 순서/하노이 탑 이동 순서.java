import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        hanoi(N, 1, 3);

        System.out.println(answer);
        System.out.println(sb);
    }

    static void hanoi(int n, int start, int end) {
        if (n == 1) {
            answer++;
            sb.append(start + " " + end + "\n");
        } else {
            if (start != 1 && end != 1) {
                hanoi(n - 1, start, 1);
                hanoi(1, start, end);
                hanoi(n - 1, 1, end);
            } else if (start != 2 && end != 2) {
                hanoi(n - 1, start, 2);
                hanoi(1, start, end);
                hanoi(n - 1, 2, end);
            } else if (start != 3 && end != 3) {
                hanoi(n - 1, start, 3);
                hanoi(1, start, end);
                hanoi(n - 1, 3, end);
            }
        }
    }
}