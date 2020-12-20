package dynamicprogramming;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author sarvesh
 * @since
 */
public class MigratoryBird {

    static int solveWithHashMap(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int e = arr[i];
            Integer c = map.get(e);
            if(c != null) {
                map.put(e, c+1);
            } else {
                map.put(e, 1);
            }
        }
        int ans = 0;
        int maxCount = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            int count = entry.getValue();
            if(count > maxCount) {
                maxCount = count;
                ans = k;
            }
        }
        return ans;
    }

    static int BS1(int[] arr, int N, int K) {
        int lo=0, hi=N-1, ans=-1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(arr[mid] == K) {
                ans = mid;
                hi = mid - 1;
            } else if(K > arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    static int BS2(int[] arr, int N, int K) {
        int lo=0, hi=N-1, ans=-1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(arr[mid] == K) {
                ans = mid;
                lo = mid + 1;
            } else if(K > arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    static int solveTwoBS(int[] arr, int N) {
        Arrays.sort(arr);
        final int[] uniqueElements = Arrays.stream(arr).distinct().toArray();
        int ans = 0;
        int maxCount = Integer.MIN_VALUE;
        for(int i = 0; i < uniqueElements.length; i++) {
            int q = uniqueElements[i];
            final int p1 = BS1(arr, N, q);
            final int p2 = BS2(arr, N, q);
            int count = p2 - p1 + 1;
            if(count > maxCount) {
                maxCount = count;
                ans = q;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());

//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());

//        final int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//        int result = solveWithHashMap(arr, n);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        result = migratoryBirdsHashMap(arr);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//        bufferedReader.close();
//        bufferedWriter.close();


        int[] arr = new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4};
        int n = arr.length;

        int result = solveWithHashMap(arr, n);
        System.out.println(result);

        result = solveTwoBS(arr, n);
        System.out.println(result);

    }
}
