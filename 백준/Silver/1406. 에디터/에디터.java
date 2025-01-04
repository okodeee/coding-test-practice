import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LinkedList<Character> list = new LinkedList<Character>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        // Iterator 메소드 호출
        ListIterator<Character> iter = list.listIterator();
        // 처음 커서의 위치는 맨 뒤
        while(iter.hasNext()) {
            iter.next();
        }

        String command;
        for (int i = 0; i < M; i++) {
            command = br.readLine();
            switch (command) {
                case "L":   // 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case "D":   // 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                    if (iter.hasNext()) iter.next();
                    break;
                case "B":   // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                    if (iter.hasPrevious()) {
                        iter.previous();
                        // remove()는 next()나 previous()에 의해 반환된 가장 마지막 요소를 리스트에서 제거
                        iter.remove();
                    }
                    break;
                default:    // P
                    iter.add(command.charAt(2));    // cursor의 위치에 추가
            }
        }
        StringBuilder sb = new StringBuilder();
        for ( char c : list) sb.append(c);
        System.out.println(sb);
    }
}