package algo.array;

import java.util.Arrays;

/**
 * @author sarvesh
 * @version 0.0.1
 * @since 0.0.1
 */
public class ReverseArray {

    private static void reverse(int[] arr, int n) {
        Arrays.stream(arr).forEach(e -> System.out.print(e+" "));
        System.out.println("");
        int[] reverse = new int[n];
        for(int i = n - 1, j = 0; i >= 0; i--, j++) {
            reverse[j] = arr[i];
        }
        Arrays.stream(reverse).forEach(e -> System.out.print(e+" "));
    }

    public static void main(String[] args) throws Exception {
        /*try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            uniqueElements(arr, t);
        }*/
        reverse(new int[]{2,19,8,15,4}, 5);
    }
}
