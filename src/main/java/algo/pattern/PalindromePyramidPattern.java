package algo.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class PalindromePyramidPattern {

    private static void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            char ch = 'A';
            int k = 2 * i + 1;
            int len = 2 * k - 1;
            char[] arr = new char[len];
            for (int j = 0; j < len/2; j = j + 2, ch ++) {
                arr[j] = ch;
                arr[j + 1] = ' ';
            }
            arr[len/2] = ch;
            ch --;
            for (int j = len/2 + 1; j < len; j = j + 2, ch --) {
                arr[j] = ' ';
                arr[j + 1] = ch;
            }
            System.out.println(new String(arr));
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
