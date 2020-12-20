package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author sarvesh
 * @version 0.0.1
 * @since 0.0.1
 */
public class SumOfTwoGenericNumbers {

    private static void sum(String a, String b) {
        final double sum = Double.sum(Double.parseDouble(a), Double.parseDouble(b));
        if(sum == Math.floor(sum)) {
            System.out.println((int)sum);
        } else {
            System.out.println(sum);
        }
    }

    public static void main(String[] args) throws Exception {
        /*try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sum(arr, t);
        }*/
        sum("2", "3");
        sum("3.3", "4");
    }
}
