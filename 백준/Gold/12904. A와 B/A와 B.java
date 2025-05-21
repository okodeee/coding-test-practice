import java.io.*;

/*
 * 문자열 S -> T
 * T -> S로 역연산 하며 판단하는 게 선택지가 줄어들고 탐색이 적음
 * => 문자열 생성/감소
 */
public class Main {
    static String S, T;
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        dfs(T);

        System.out.println(result ? 1 : 0);
    }

    static void dfs(String current) {
//        System.out.println(current);
        if (current.length() == S.length()) {
            if (current.equals(S)) {
                result = true;
            }
            return;
        }

        if (current.endsWith("A")) {
            dfs(current.substring(0, current.length() - 1));
        }

        if (current.endsWith("B")) {
            String reversed = new StringBuilder(current.substring(0, current.length() - 1)).reverse().toString();
            dfs(reversed);
        }
    }
}