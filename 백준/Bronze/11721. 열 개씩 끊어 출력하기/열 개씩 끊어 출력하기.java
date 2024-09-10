import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // String.substring
        int length = str.length();
        for (int i = 0; i < length; i += 10) {
            if (i + 10 < length) {
                System.out.println(str.substring(i, i + 10));
            } else {
                System.out.println(str.substring(i)); // str.substring(i, length)
            }
        }
    }
}