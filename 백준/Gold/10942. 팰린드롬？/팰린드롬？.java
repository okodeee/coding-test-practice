import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 팰린드롬 구하기
        boolean[][] palindrome = new boolean[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            palindrome[0][i] = true;
        }
        for (int i = 1; i <= N; i++) {
            palindrome[i][i] = true;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (j + 1 == i) {
                    palindrome[j][i] = nums[j] == nums[i];
                } else {
                    palindrome[j][i] = (palindrome[j + 1][i - 1] && nums[i] == nums[j]);
                }
            }
        }

//        printPalindrome(palindrome);

        int M = Integer.parseInt(br.readLine());
        int S, E;
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            sb.append(palindrome[S][E] ? 1 : 0).append('\n');
        }

        System.out.println(sb);
    }

    static void printPalindrome(boolean[][] palindrome) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < palindrome.length; i++) {
            for (int j = 0; j < palindrome[i].length; j++) {
                sb.append(palindrome[i][j] ? 1 : 0).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}