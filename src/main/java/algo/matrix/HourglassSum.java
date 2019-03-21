package algo.matrix;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Given a 6 X 6 2D Array, arr:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

We define an hourglass in A to be a subset of values with indices falling in this pattern in arr's graphical representation:

a b c
  d
e f g

There are 16 hourglasses in arr, and an hourglass sum is the sum of an hourglass' values.
Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.

For example, given the 2D array:

-9 -9 -9  1  1  1
 0 -9  0  4  3  2
-9 -9 -9  1  2  3
 0  0  8  6  6  0
 0  0  0 -2  0  0
 0  0  1  2  4  0

We calculate the following 16 hourglass values:

-63, -34, -9, 12,
-10, 0, 28, 23,
-27, -11, -2, 10,
9, 17, 25, 18
Our highest hourglass value is 28 from the hourglass:
0 4 3
  1
8 6 6

Function Description

Complete the function hourglassSum in the editor below.
It should return an integer, the maximum hourglass sum in the array.

hourglassSum has the following parameter(s):
    arr: an array of integers

Input Format
Each of the 6 lines of inputs arr[i] contains 6 space-separated integers arr[i][j].

Constraints
-9 <= arr[i][j] <= 9
0 <= i, j <= 5

Output Format
Print the largest (maximum) hourglass sum found in arr.

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Sample Output
19

Explanation

The hourglass with the maximum sum (19) is:
2 4 4
  2
1 2 4
*/
public class HourglassSum {
    static int hourglassSum(int[][] arr) {
        int maxHgSum = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int[][] prefixSumArr = new int[arr.length][arr.length+1];
        for(i = 0; i < arr.length; i++) {
            int[] row = arr[i];
            for(j = 1; j < row.length+1; j++) {
                prefixSumArr[i][j] = prefixSumArr[i][j-1] + row[j-1];
            }
        }
        int currentTopRow = 0;
        int currentBottomRow = 2;
        int windowCursor = 3;
        int windowFixSize = 3;
        int iCenter = 1, jCenter = 1;
        for(i = 0; i < 4; i++) {
            for(j = 0; j < 4; j++) {
                int sum = ( prefixSumArr[currentTopRow][windowCursor] - prefixSumArr[currentTopRow][windowCursor-windowFixSize] )
                        + arr[iCenter][jCenter]
                        + ( prefixSumArr[currentBottomRow][windowCursor] - prefixSumArr[currentBottomRow][windowCursor-windowFixSize] );
                if(sum > maxHgSum) {
                    maxHgSum = sum;
                }
                windowCursor++;
                jCenter++;
            }
            currentTopRow++;
            currentBottomRow++;
            iCenter++;
            jCenter = 1;
            windowCursor = 3;
        }
        return maxHgSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        int result = hourglassSum(arr);
        System.out.println(String.valueOf(result));
        scanner.close();
    }
}
