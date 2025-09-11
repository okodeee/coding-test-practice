import java.io.*;
import java.util.*;


public class Main {
    static int[][] array = new int[101][101];
    static int rows = 3, cols = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 4; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time <= 100) {
            if (array[r][c] == k) {
                System.out.println(time);
                return;
            }

            // 100초 초과시 종료
            if (time == 100) break;

            if (rows >= cols) {
                rowSort();
            } else {
                colSort();
            }

            time++;
        }

        System.out.println(-1);
    }

    static void rowSort() {
        int newCols = 0;
        int[][] newArray = new int[101][101];

        for (int i = 1; i <= rows; i++) {
            List<int[]> sortedRow = new ArrayList<>();

            Map<Integer, Integer> countMap =  new HashMap<>();
            for (int j = 1; j <= cols; j++) {
                int value = array[i][j];
                if (value != 0) {
                    countMap.put(value, countMap.getOrDefault(value, 0) + 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                sortedRow.add(new int[]{entry.getKey(), entry.getValue()});
            }

            sortedRow.sort((a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1];   // 등장횟수로 먼저 정렬
                return a[0] - b[0]; // 등장횟수 같으면 수로 정렬
            });

            int colIndex = 1;
            for (int[] pair : sortedRow) {
                if (colIndex > 100) break;
                newArray[i][colIndex++] = pair[0];
                if (colIndex > 100) break;
                newArray[i][colIndex++] = pair[1];
            }

            newCols = Math.max(newCols, Math.min(100, colIndex - 1));
        }

        array = newArray;
        cols = newCols;
    }

    static void colSort() {
        int newRows = 0;
        int[][] newArray = new int[101][101];

        for (int j = 1; j <= cols; j++) {
            List<int[]> sortedCol = new ArrayList<>();

            Map<Integer, Integer> countMap =  new HashMap<>();
            for (int i = 1; i <= rows; i++) {
                int value = array[i][j];
                if (value != 0) {
                    countMap.put(value, countMap.getOrDefault(value, 0) + 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                sortedCol.add(new int[]{entry.getKey(), entry.getValue()});
            }

            sortedCol.sort((a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1];   // 등장횟수로 먼저 정렬
                return a[0] - b[0]; // 등장횟수 같으면 수로 정렬
            });

            int rowIndex = 1;
            for (int[] pair : sortedCol) {
                if (rowIndex > 100) break;
                newArray[rowIndex++][j] = pair[0];
                if (rowIndex > 100) break;
                newArray[rowIndex++][j] = pair[1];
            }


            newRows = Math.max(newRows, Math.min(100, rowIndex - 1));
        }

        array = newArray;
        rows = newRows;
    }
}