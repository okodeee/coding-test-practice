import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// BigInteger****
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str;
        StringBuilder num = new StringBuilder();
        List<BigInteger> newList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (char ch : str.toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    if (num.length() > 0) {
                        newList.add(new BigInteger(num.toString()));    // 배열에 숫자 저장
                        num = new StringBuilder();// 초기화
                    }
                } else {
                    num.append(ch);
                }
            }
            if (num.length() > 0) {
                newList.add(new BigInteger(num.toString()));    // 배열에 숫자 저장
                num = new StringBuilder();// 초기화
            }
        }
        newList.sort(Comparator.naturalOrder());    // 오름차순으로 정렬
        newList.forEach(System.out::println);   // 리스트 출력
    }
}
