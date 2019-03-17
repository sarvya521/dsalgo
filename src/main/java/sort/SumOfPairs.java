package sort;

import java.util.Arrays;

/*
Given an array of integers and a number K, check if there exist a pair of indices i,j s.t. a[i] + a[j] = K and i!=j.

Input Format

First line of input contains T - number of test cases.
Its followed by 2T lines, first line of each test case contains N - size of the array and K,
and the next line contains N integers - the elements of the array. 

Constraints

30 points 
1 <= T <= 100 
2 <= N <= 1000 

70 points 
1 <= T <= 300 
2 <= N <= 10000 

General Constraints 
-108 <= K <= 108 
-108 <= ar[i] <= 108 

Output Format

For each test case, print "True" if such a pair exists, "False" otherwise, separated by newline. 

Sample Input 0

3
5 -15
-30 15 20 10 -10 
2 20
10 10 
4 7
-4 0 10 -7 
Sample Output 0

True
True
False
 */
public class SumOfPairs {

	static boolean solve(int[] arr, int k) {
		Arrays.sort(arr); // -30 -10 10 15 20
		int n = arr.length;
		int p1 = 0;
		int p2 = n-1;
		int sum = 0;
		while(p1 != p2) {
			sum = arr[p1]+arr[p2];
			if(sum == k) {
				return true;
			}
			if(sum < k) {
				p1++;
			} else {
				p2--;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{-30, 15, 20, 10, -10};
		int k = -15;
		System.out.println(solve(arr, k));
	}

}
