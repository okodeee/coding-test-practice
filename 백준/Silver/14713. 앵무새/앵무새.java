import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<String>[] parrot = new Queue[N];

        for (int i = 0; i < N; i++) {
            String input =  br.readLine();
            parrot[i] = new LinkedList<String>();
            for (String s :  input.split(" ")) {
                parrot[i].add(s);
            }
        }

        String[] cseteram = br.readLine().split(" ");

        boolean isPossible = false;

        for (String s : cseteram) {
            isPossible = false;

            for (int i = 0; i < N; i++) {
                if (!parrot[i].isEmpty() && s.equals(parrot[i].peek())) {
                    parrot[i].poll();
                    isPossible = true;
                    i = N;
                }
            }

            if (!isPossible) {
                System.out.println("Impossible");
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!parrot[i].isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }

        System.out.println("Possible");
    }
}