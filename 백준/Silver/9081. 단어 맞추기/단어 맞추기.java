import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String word = br.readLine();
            char[] arr = word.toCharArray();

            if (nextPermutation(arr)) {
                System.out.println(new String(arr));
            } else {
                System.out.println(word);
            }
        }
    }

    // 다음 사전 순 순열 구하는 함수
    static boolean nextPermutation(char[] arr) {
        int i = arr.length - 1;

        // Step 1: 뒤에서부터 i-1 < i를 찾는다
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i <= 0) return false; // 마지막 순열

        // Step 2: arr[i - 1] < arr[j]인 j를 찾고 swap
        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        swap(arr, i - 1, j);

        // Step 3: i부터 끝까지 뒤집기
        reverse(arr, i, arr.length - 1);

        return true;
    }

    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}
