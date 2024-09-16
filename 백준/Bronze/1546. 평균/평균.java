import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] scores = new int[n];
        int M = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 기존 과목 점수 저장
        for(int i = 0; i < n; i++){
            scores[i] = Integer.parseInt(st.nextToken());
            if (scores[i] > M) M = scores[i];
        }

        double sum = 0;
        double[] scores_new = new double[n];
        for(int i = 0; i < n; i++){
            scores_new[i] = (double)scores[i] / M * 100; // (int)/(int) 연산은 (int)이므로 형변환해준다.
            sum += scores_new[i];
        }
        System.out.println(sum / n);
    }
}