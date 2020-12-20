package algo.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author sarvesh
 * @version 0.0.1
 * @since 0.0.1
 */
public class UniqueElements {

    private static void uniqueElements(int[] arr, int n) {
        Arrays.stream(arr).forEach(e -> System.out.print(e+" "));
        System.out.println("");
        for(int i = 0; i < n; i++) {
            if(arr[i] != -1) {
                boolean duplicate = false;
                for (int j = i+1; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        arr[j] = -1;
                        duplicate = true;
                    }
                }
                if(duplicate) {
                    arr[i] = -1;
                }
            }
        }
        Arrays.stream(arr).filter(e -> e > -1).forEach(e -> System.out.print(e+" "));
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            uniqueElements(arr, t);
        }
        uniqueElements(new int[]{5,4,10,9,21,4,10}, 7);
    }
}
