package algo.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class SumOfMatrix {
    private static void sumOfMatrix(int n, int m, List<String> lines) {
        for(int i = 0; i < n; i++) {
            final int[] mat1Row = Arrays.stream(lines.get(i).split(" ")).mapToInt(Integer::parseInt).toArray();
            final int[] mat2Row = Arrays.stream(lines.get(i+n).split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                System.out.print(mat1Row[j] + mat2Row[j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws Exception {
        int n = 0;
        int m = 0;
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final String[] nm = br.readLine().split(" ");
            n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);
            int rows = n * 2;
            while(rows > 0) {
                lines.add(br.readLine());
                rows --;
            }
        }
        sumOfMatrix(n, m, lines);
    }
}
