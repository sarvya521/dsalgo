package algo.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class HollowRectanglePattern {

    private static void printPattern(int w, int l) {
        for(int i = 1; i <= l; i++) {
            System.out.print("*");
            char ch = (i == 1 || i == l) ? '*' : ' ';
            for(int j = 2; j < w; j++) {
                System.out.print(ch);
            }
            System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        String[] arr = input.split(" ");
        printPattern(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
    }
}
