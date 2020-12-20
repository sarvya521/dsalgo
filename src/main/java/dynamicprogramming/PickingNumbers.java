package dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author sarvesh
 * @since
 */
public class PickingNumbers {

    /*
    sort the array
    take a count array
    verify adjacent elements and their counts
     */
    public static int pickingNumbers(List<Integer> list) {
        Collections.sort(list);
        final Map<Integer, Long> frequencyMap = list.stream().collect(Collectors.groupingBy(Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()));
        Long ans = 0l;
        Long finalAns = 0l;
        final Integer[] numbers = frequencyMap.keySet().toArray(new Integer[0]);
        int n = numbers.length;
        ans = frequencyMap.get(numbers[0]);
        for(int i = 1; i < n; i++) {
            if(numbers[i] - numbers[i-1] > 1) {
                if(ans > finalAns) {
                    finalAns = ans;
                }
                ans = frequencyMap.get(numbers[i]);
            } else {
                ans += frequencyMap.get(numbers[i]);
            }
        }
        if(ans > finalAns) {
            finalAns = ans;
        }
        return finalAns.intValue();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 6, 5, 3, 3, 1);
        System.out.println(pickingNumbers(list));
    }

}
