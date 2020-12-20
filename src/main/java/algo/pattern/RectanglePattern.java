package algo.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class RectanglePattern {

    private static void printPattern(int n) {
       for(int i = 1; i <= n; i++) {
           for(int j = n; j > 0; j--) {
               if(j == i) {
                   System.out.print("*");
               } else {
                   System.out.print(j);
               }
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
