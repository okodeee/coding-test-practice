import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();  // n은 쓸모가 없으므로 입력만 받음
        int sum = 0;

        /* getBytes
         * String에 대하여 해당 문자열을 하나의 byte 배열로 변환해주는 메소드
         * 이 때, 변환되는 방법은 Charset 에서 사용되는 인코딩 방식, 즉 UTF-16 인코딩으로 변경되는 값을 따름
         */
        for (byte value : br.readLine().getBytes()) {   // for-each 구문
            sum += (value - '0');   // 또는 (value - 48) :: 문자 -> 숫자
        }

        System.out.println(sum);
    }
}