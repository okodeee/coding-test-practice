import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        int[] alphabets = new int[26];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            int length = word.length();
            for (int j = 0; j < length; j++) {
                alphabets[word.charAt(j) - 'A'] += (int) Math.pow(10, length - j - 1);
            }
            words[i] = word;
        }

        Integer[] sortedAlphabets = new Integer[26];
        for (int i = 0; i < 26; i++) {
            sortedAlphabets[i] = alphabets[i];
        }
        Arrays.sort(sortedAlphabets, (a, b) -> b - a);

        int result = 0;
        for (int i = 9; i >= 0; i--) {
            result += sortedAlphabets[9 - i] * i;
        }

        System.out.println(result);
    }
}