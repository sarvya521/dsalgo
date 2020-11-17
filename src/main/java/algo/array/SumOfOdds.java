package algo.array;

import java.util.Arrays;

/**
 * @author sarvesh
 * @version 0.0.1
 * @since 0.0.1
 */
public class SumOfOdds {

    private static void sumOfOdds(int[] arr, int n) {
        long sum = 0;
        for(int i = 0; i < n; i++) {
            if((arr[i] & 1) == 1) {
                sum += arr[i];
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        /*try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sumOfOdds(arr, t);
        }*/
        sumOfOdds(new int[]{6,9,8,4,3}, 5);
    }
}
