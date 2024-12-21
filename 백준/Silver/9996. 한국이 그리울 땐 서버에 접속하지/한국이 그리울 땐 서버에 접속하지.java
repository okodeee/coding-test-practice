import java.io.*;

/*
 * 문제: 예약어로 사용되는 일부 특수문자는 split(), replaceAll() 사용 시 인식 불가
 * 해결 방안: 특수문자를 인식할 수 있도록 "\\*" or "[*]"로 사용
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String arr[] = pattern.split("\\*");

        for (int i = 0; i < N; i++) {
            String file = br.readLine();
            if (file.startsWith(arr[0])) {
                file = file.substring(arr[0].length());
                if (file.endsWith(arr[1])) {
                    System.out.println("DA");
                    continue;
                }
            }
            System.out.println("NE");
        }
    }
}
