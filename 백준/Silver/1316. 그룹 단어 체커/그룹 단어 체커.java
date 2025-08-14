import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (groupWord(input)) count++;
        }

        System.out.println(count);
    }

    static boolean groupWord(String input) {
        HashSet<Character> characters = new HashSet<>();

        Character prev = input.charAt(0);
        characters.add(prev);

        Character curr;
        for (int i = 1; i < input.length(); i++) {
            curr = input.charAt(i);
            if (characters.contains(curr) && curr != prev) {
                return false;
            }
            characters.add(curr);
            prev = curr;
        }
        return true;
    }
}