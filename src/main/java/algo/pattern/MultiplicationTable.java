package algo.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class MultiplicationTable {

    private static void print(int n) {
       for(int i = 1; i <= 10; i++) {
           System.out.println(n + " * " + i + " = " + (n * i));
       }
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        print(Integer.parseInt(input));
    }
}
