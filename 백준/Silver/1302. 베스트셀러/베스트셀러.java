import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> bookCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            bookCount.put(book, bookCount.getOrDefault(book, 0) + 1);
        }

        String result = "";
        int max = 0;
        for (String key : bookCount.keySet()) {
            if (bookCount.get(key) > max) {
                result = key;
                max = bookCount.get(key);
            } else if (bookCount.get(key) == max && key.compareTo(result) < 0) {
                result = key;
            }
        }

        System.out.println(result);
    }
}