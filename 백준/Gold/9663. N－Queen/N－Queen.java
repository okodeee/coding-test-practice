import java.util.*;
import java.io.*;

public class Main {

    public static int[] arr;
    public static int N;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        nQueen(1);

        System.out.println(count);
    }

    public static void nQueen(int depth) {
        // 모든 원소를 다 채운 상태면 count 증가 및 return
        if (depth == N + 1) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            // 놓을 수 있는 위치일 경우 재귀호출
            if (isPromising(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean isPromising(int col) {
        for (int i = 1; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            }

            // 대각선상에 놓여있는 경우
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}