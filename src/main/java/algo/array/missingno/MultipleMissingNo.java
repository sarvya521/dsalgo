package algo.array.missingno;

import java.util.Arrays;

/**
 * @author sarvesh
 * @since
 */
public class MultipleMissingNo {
    public static void main(String[] args) {
        int[] input = new int[]{1,5,3,2,9};
        int max = 9;
        int[] copyArray = new int[10];//9+1
        for(int i : input) {
            copyArray[i] = 1;
        }
        System.out.println("missing numbers:");
        for(int i = 1; i <= max; i++) {
            if(copyArray[i] == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
