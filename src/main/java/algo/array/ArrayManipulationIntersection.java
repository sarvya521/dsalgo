package algo.array;

import java.io.IOException;
import java.util.*;

public class ArrayManipulationIntersection {
    private static final Scanner scanner = new Scanner(System.in);

    static long arrayManipulation(int n, int[][] queries) {
        int []arr = new int[n + 2];
        // Start performing 'm' operations
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            // Store lower and upper
            // index i.e. range
            int lowerbound = query[0];
            int upperbound = query[1];
            int k = query[2];

            // Add k to the lower_bound
            arr[lowerbound] += k;

            // Reduce upper_bound+1
            // indexed value by k
            arr[upperbound + 1] -= k;
        }

        // Find maximum sum
        // possible from all values
        long sum = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < n + 2; ++i) {
            sum += arr[i];
            res = Math.max(res, sum);
        }

        // return maximum value
        return res;
    }

    public static void main(String[] args) throws IOException {
        /*String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(String.valueOf(result));
        scanner.close();*/
        /*int n = 10;
        int[][] queries = {{1, 5, 3}, {4, 8, 7}, {6, 9, 1}};
        System.out.println(arrayManipulation(n, queries));*/
        /*int n = 4;
        int[][] queries = {{2, 3, 603}, {1, 1, 286}, {4, 4, 882}};
        System.out.println(arrayManipulation(n, queries));*/
        int n = 8;
        int[][] queries = {{6, 8, 100}, {5, 5, 500}, {5, 6, 100}, {1, 3, 400}, {8, 8, 600}};
        System.out.println(arrayManipulation(n, queries));
        /*int n = 7;
        int[][] queries = {{2, 2, 286}, {3, 5, 603}, {6, 6, 882}, {6, 7, 1}};
        System.out.println(arrayManipulation(n, queries));*/
    }
}

