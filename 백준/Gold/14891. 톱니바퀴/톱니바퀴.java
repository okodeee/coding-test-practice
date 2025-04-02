import java.io.*;
import java.util.*;

public class Main {
    static Deque<Character>[] gears = new Deque[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니 상태 입력
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            gears[i] = new ArrayDeque<>();
            for (char c : line.toCharArray()) {
                gears[i].add(c);
            }
        }

        // 회전 명령 수행
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int[] rotateDir = new int[4];
            rotateDir[gearNum] = dir;

            // 왼쪽 톱니바퀴로 전파
            for (int i = gearNum; i > 0; i--) {
                char leftRight = getRight(gears[i - 1]);
                char rightLeft = getLeft(gears[i]);

                if (leftRight != rightLeft) {
                    rotateDir[i - 1] = -rotateDir[i];
                } else {
                    break;
                }
            }

            // 오른쪽 톱니바퀴로 전파
            for (int i = gearNum; i < 3; i++) {
                char rightLeft = getLeft(gears[i + 1]);
                char leftRight = getRight(gears[i]);

                if (leftRight != rightLeft) {
                    rotateDir[i + 1] = -rotateDir[i];
                } else {
                    break;
                }
            }

            // 회전 실행
            for (int i = 0; i < 4; i++) {
                if (rotateDir[i] == 1) rotateClockwise(gears[i]);
                else if (rotateDir[i] == -1) rotateCounterClockwise(gears[i]);
            }
        }

        // 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].peekFirst() == '1') {
                score += (1 << i); // 1, 2, 4, 8
            }
        }


        System.out.println(score);
    }

    static void rotateClockwise(Deque<Character> gear) {
        gear.addFirst(gear.pollLast());
    }

    static void rotateCounterClockwise(Deque<Character> gear) {
        gear.addLast(gear.pollFirst());
    }

    static char getRight(Deque<Character> gear) {
        Iterator<Character> it = gear.iterator();
        it.next(); it.next(); // 0, 1
        return it.next(); // 2
    }

    static char getLeft(Deque<Character> gear) {
        Iterator<Character> it = gear.iterator();
        for (int i = 0; i < 6; i++) it.next();
        return it.next(); // 6
    }
}