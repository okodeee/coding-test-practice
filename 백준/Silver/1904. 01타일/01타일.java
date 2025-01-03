import java.io.*;

/*
 * 1: 01
 * 2: 00, 11
 * 3: 001 (1), 100, 111 (2)
 */

public class Main {
    static int[] tiles = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tiles[1] = 1;
        tiles[2] = 2;

        for (int i = 3; i <= N; i++) {
            tiles[i] = (tiles[i-1] + tiles[i-2]) % 15746;
        }

        System.out.println(tiles[N]);
    }
}