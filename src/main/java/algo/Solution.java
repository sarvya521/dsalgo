package algo;

import java.util.Arrays;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class Solution {

    public static int maxDifference(List<Integer> px) {
        if(px.size() == 1) {
            return -1;
        }
        int max_diff = px.get(1) - px.get(0);
        int min_element = px.get(0);
        for (int i = 1; i < px.size(); i++) {
            if (px.get(i) - min_element > max_diff)
                max_diff = px.get(i) - min_element;
            if (px.get(i) < min_element)
                min_element = px.get(i);
        }
        return max_diff < 0 ? -1 : max_diff;
    }

    public static void main(String[] args) {
        System.out.println(maxDifference(Arrays.asList(7, 1, 2, 5)));
        System.out.println(maxDifference(Arrays.asList(7, 5, 3, 1)));
        System.out.println(maxDifference(Arrays.asList(2, 3, 10, 2, 4, 8, 1)));
        System.out.println(maxDifference(Arrays.asList(7, 9, 5, 6, 3, 2)));

        System.out.println(maxDifference(Arrays.asList(10, 8, 7, 6, 5)));
    }
}
