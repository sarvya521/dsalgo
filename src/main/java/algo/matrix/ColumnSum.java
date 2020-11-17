package algo.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sarvesh
 * @since
 */
public class ColumnSum {
    private static void columnSum(int n, int m, List<String> lines) {
        final List<int[]> rows = lines.stream()
                .map(line -> Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray())
                .collect(Collectors.toList());
        for(int j = 0; j < m; j++) {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += rows.get(i)[j];
            }
            System.out.println(sum);
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
            int rows = n;
            while(rows > 0) {
                lines.add(br.readLine());
                rows --;
            }
        }
        columnSum(n, m, lines);
    }
}
