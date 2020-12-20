package algo.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class InvertedPyramidPattern {

    private static void printPattern(int n) {
       for(int i = 0; i < n; i++) {
           System.out.print("* ");
           char ch = i == 0 ? '*' : ' ';
           for(int j = 1; j < n - i - 1; j++) {
               System.out.print(ch+" ");
           }
           if(i != n - 1) {
               System.out.print("*");
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
