import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] subtractions = input.split("-");

        int result = 0;
        boolean isFirst = true;

        for (String s : subtractions) {
            int sum = 0;
            // "+"는 정규 표현식에서 특수 문자이므로, 일반 문자로 사용하려면 **이스케이프(\+)**가 필요하다.
            // Java의 문자열에서 \ 자체를 쓰려면 \\를 두 번 사용해야 한다.
            String[] additions = s.split("\\+");
            for (String add : additions) {
                sum += Integer.parseInt(add);
            }

            if (isFirst) {
                result += sum;
                isFirst = false;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
