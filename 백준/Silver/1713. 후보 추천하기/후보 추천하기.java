import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        int id; // 학생 번호
        int votes;  // 추천 수
        int time;   // 게시된 시점

        public Student(int id, int votes, int time) {
            this.id = id;
            this.votes = votes;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Student> frames = new ArrayList<>();
        int time = 0;

        while(st.hasMoreTokens()) {
            int id = Integer.parseInt(st.nextToken());
            time++;

            // case1: 학생이 이미 사진틀에 있음 -> 추천 수 + 1
            boolean exists = false;

            for (Student s : frames) {
                if (s.id == id) {
                    exists = true;
                    s.votes++;
                }
            }
            if (exists) continue;

            // case2: 학생이 사진틀에 없음
            if (frames.size() < N) {    // 사진틀에 공간이 있음
                frames.add(new Student(id, 1, time));
            } else {    // 사진틀에 공간이 없음 (가장 추천 수 낮은 학생 제거)
                // 리스트 정렬 후 삭제
                frames.sort((a, b) -> {
                    if (a.votes == b.votes) return Integer.compare(a.time, b.time);
                    return Integer.compare(a.votes, b.votes);
                });
                frames.remove(0);
                frames.add(new Student(id, 1, time));
            }
        }

        frames.sort((a, b) -> Integer.compare(a.id, b.id));
        for (Student s : frames) {
            System.out.print(s.id + " ");
        }
    }
}