import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[] data;
    static int[] prev, next;
    static int cursor;
    static int currentIndex;
    static final int MAX_LENGTH = 600_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String initialString = br.readLine();
        int commandCount = Integer.parseInt(br.readLine());

        data = new char[MAX_LENGTH];
        prev = new int[MAX_LENGTH];
        next = new int[MAX_LENGTH];

        cursor = 0;
        currentIndex = 1;

        prev[0] = -1;
        next[0] = -1;

        for (char c : initialString.toCharArray()) {
            insert(c);
        }

        for (int i = 0; i < commandCount; i++) {
            String command = br.readLine();
            char cmdType = command.charAt(0);

            switch (cmdType) {
                case 'L':
                    if (prev[cursor] != -1) {
                        cursor = prev[cursor];
                    }
                    break;
                case 'D':
                    if (next[cursor] != -1) {
                        cursor = next[cursor];
                    }
                    break;
                case 'B':
                    if (prev[cursor] != -1) {
                        delete();
                    }
                    break;
                case 'P':
                    char ch = command.charAt(2);
                    insert(ch);
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        int index = next[0];
        while (index != -1) {
            result.append(data[index]);
            index = next[index];
        }

        System.out.println(result);
    }

    static void insert(char ch) {
        if (currentIndex >= MAX_LENGTH) {
            return;
        }
        data[currentIndex] = ch;
        prev[currentIndex] = cursor;
        next[currentIndex] = next[cursor];

        if (next[cursor] != -1) {
            prev[next[cursor]] = currentIndex;
        }

        next[cursor] = currentIndex;
        cursor = currentIndex;
        currentIndex++;
    }

    static void delete() {
        if (cursor == 0 || cursor >= currentIndex) {
            return;
        }
        if (next[cursor] != -1) {
            prev[next[cursor]] = prev[cursor];
        }
        if (prev[cursor] != -1) {
            next[prev[cursor]] = next[cursor];
        }
        cursor = prev[cursor];
    }
}