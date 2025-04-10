import java.io.*;
import java.util.*;

// 0~9 중에서 중복 없이 몇 개 뽑아서 내림차순으로 나열하면 감소하는 수
public class Main {
    static List<Long> list = new ArrayList<>();

    static void dfs(long num, int lastDigit) {
        list.add(num);
        for (int i = 0; i < lastDigit; i++) { // 이전 자리의 값보다 작은 것만
            dfs(num * 10 + i, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) {
            dfs(i, i); // 시작 자리수, 마지막 자릿값
        }

        Collections.sort(list);
        if (N >= list.size()) System.out.println(-1);
        else System.out.println(list.get(N));

    }
}