package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class SumOfDigits {
    private static void sumOfDigits(String n) {
        int sum = 0;
        while(n.length() > 0) {
            sum += Integer.parseInt(n.charAt(n.length() - 1)+"");
            n = n.substring(0, n.length() - 1);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        /*try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            sumOfDigits(br.readLine());
        }*/
        sumOfDigits("164");
    }
}
