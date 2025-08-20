import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> serial = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            serial.add(br.readLine());
        }

        serial.sort((String o1, String o2) -> {
            if (o1.length() == o2.length()) {
                int o1Sum = 0, o2Sum = 0;

                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                        o1Sum += o1.charAt(i) - '0';
                    }
                }

                for (int i = 0; i < o2.length(); i++) {
                    if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                        o2Sum += o2.charAt(i) - '0';
                    }
                }

                if (o1Sum == o2Sum) return o1.compareTo(o2);

                return o1Sum - o2Sum;
            }
            return o1.length() - o2.length();
        });

        for (int i = 0; i < serial.size(); i++) {
            System.out.println(serial.get(i));
        }
    }
}