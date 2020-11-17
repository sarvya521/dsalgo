package sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
Given an array, find the length of the longest subsequence 
whose elements can be re-arranged in a strictly increasing contiguous order.
The difference between 2 adjacent elements in the subsequence, after re-arrangement, should be exactly 1. 

Input Format

First line of input contains T - number of test cases.
Its followed by 2T lines.
First line of each test case contains N - size of the array.
The next line contains N integers - the elements of the array. 

Constraints

1 <= T <= 1000 
1 <= N <= 10000 
-1000 <= ar[i] <= 1000

Output Format

For each test case, print the length of the longest subsequence, separated by newline. 

Sample Input 0

3
8
21 -22 -22 5 -31 -24 5 -23 
10
18 -33 31 33 30 -14 32 30 16 17 
6
6 3 8 5 2 5 
Sample Output 0

3
4
2
Explanation 0

Test Case 1
Subsequence is: -22, -24, -23.

Test Case 2
Subsequence is: 31, 33, 30, 32.

Test Case 3
Subsequence is: 6, 5 or 3, 2.
 */
public class MaximumContiguousSubsequence {

    static int solve(int[] arr) {
    	Arrays.sort(arr);
        int n = arr.length;
        int l = 1;
        for (int i=0; i<n-1; i++) {
            if(arr[i] == arr[i+1]) {
            	continue;
            }
            int min = arr[i];
            int max = arr[i];
            for (int j=i+1; j<n; j++) {
                if (arr[j] == arr[j-1]) {
                    continue;
                } else if(arr[j]-arr[j-1] > 1) {
                	break;
                }
                max = arr[j];
                int len = Math.abs(max-min)+1;
                if (len > l) {
                	l = len;
                }
            }
        }
        return l;
    }
    
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			System.out.println(solve(arr));
		}
		in.close();*/
    	int[] arr = new int[]{18, -33, 31, 33, 30, -14, 32, 30, 16, 17};
    	System.out.println(solve(arr));
    }
}
