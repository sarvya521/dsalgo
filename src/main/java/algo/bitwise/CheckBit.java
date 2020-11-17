package algo.bitwise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class CheckBit {
    private static void checkBit(int n, int i) {
        while(i > 0) {
            n = n >> 1;
            i--;
        }
        if((n & 1) == 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void main(String[] args) throws Exception {
        /*String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        final String[] ip = input.split(" ");
        checkBit(Integer.parseInt(ip[0]), Integer.parseInt(ip[1]));*/
        checkBit(10, 2);
    }
}
