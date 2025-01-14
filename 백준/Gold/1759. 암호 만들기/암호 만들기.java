import static javax.swing.text.html.HTML.Attribute.N;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/* C개 중에 L개로 조합 (사전식이기 때문)
 * 암호는 최소 한 개의 모음, 두 개의 자음(promising)
 */
public class Main {
    public static char[] alpha;
    public static char[] code;
    public static int L, C;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alpha);

        code = new char[L];
        sb = new StringBuilder();
        makeCode(0, 0);

        System.out.println(sb);
    }

    public static void makeCode(int x, int idx) {
        // 모든 원소를 다 채운 상태면 출력 및 return
        if (idx == L) {
            if (isPromising()) sb.append(code).append('\n');
            return;
        }

        // 미완성일 때
        for (int i = x; i < C; i++) {
            code[idx] = alpha[i];
            makeCode(i + 1, idx + 1);
        }
    }

    public static boolean isPromising() {
        int vowel = 0, consonant = 0;
        for (char c : code) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else consonant++;
        }
        if (vowel >= 1 && consonant >= 2) {
            return true;
        }
        return false;
    }
}