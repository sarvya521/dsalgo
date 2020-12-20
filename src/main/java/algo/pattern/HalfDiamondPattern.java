package algo.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class HalfDiamondPattern {

    private static void printPattern(int n) {
        int r = n * 2 - 1;
        int k = 0;
        for(int i = 1; i <= r; i++) {
            if(i > n) {
                k = k - 1;
            } else {
                k = i;
            }
            for(int j = 0; j < k; j ++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        /*String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        printPattern(Integer.parseInt(input));*/
        printPattern(5);
    }
}
