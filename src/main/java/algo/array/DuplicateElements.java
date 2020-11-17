package algo.array;

import java.util.Arrays;

/**
 * @author sarvesh
 * @version 0.0.1
 * @since 0.0.1
 */
public class DuplicateElements {

    private static void duplicateElements(int[] arr, int n) {
        Arrays.stream(arr).forEach(e -> System.out.print(e+" "));
        System.out.println("");
        for(int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        /*try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            duplicateElements(arr, t);
        }*/
        duplicateElements(new int[]{5,4,10,9,21,4,10}, 7);
    }
}
