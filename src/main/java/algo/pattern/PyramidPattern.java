package algo.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class PyramidPattern {

    private static void printPattern(int n) {
        int m = 2 * n - 1;
        int mid = m / 2;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < mid - i; j++) {
                System.out.print(' ');
            }
            for(int j = mid - i; j <= mid + i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        printPattern(Integer.parseInt(input));
    }
}
