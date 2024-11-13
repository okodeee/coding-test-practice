import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder output = new StringBuilder();

        do {
            if (input.length() >= 4 && input.substring(0, 4).equals("XXXX")) {
                output.append("AAAA");
                input = input.substring(4);
            } else if (input.length() >= 2 && input.substring(0, 2).equals("XX")) {
                output.append("BB");
                input = input.substring(2);
            } else if (input.charAt(0) == '.') {
                output.append(".");
                input = input.substring(1);
            } else {
                System.out.println(-1);
                return;
            }
        } while (!input.isEmpty());

        System.out.println(output);
    }
}