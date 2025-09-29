import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String code = br.readLine();
        int length = code.length();
        
        if (length == 1 && code.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] cases = new int[length + 1];
        cases[length - 1] = 1;
        cases[length] = 1;
        for (int i = length - 2; i >= 0; i--) {
            char num = code.charAt(i);
            char nextNum = code.charAt(i + 1);

            if (nextNum == '0') {
                if (num == '1' || num == '2') {
                    cases[i] = cases[i + 2];
                } else {
                    // 잘못된 암호
                    System.out.println(0);
                    return;
                }
            } else {
                if (num == '0') {
                    continue;
                } // 1n 인 경우
                else if (num == '1') {
                    cases[i] = (cases[i + 1] + cases[i + 2]) % 1000000;
                }   // 2n 인 경우
                else if (num == '2' && (nextNum >= '1' && nextNum <= '6')) {
                    cases[i] = (cases[i + 1] + cases[i + 2]) % 1000000;
                } else {
                    cases[i] = cases[i + 1];
                }
            }
        }

        System.out.println(cases[0]);
    }
}