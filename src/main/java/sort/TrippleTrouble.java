package sort;

import java.util.Arrays;
import java.util.Scanner;

/*
Given an array of size 3X+1, where every element occurs three times, except one element, which occurs only once. 
Find the element that occurs only once.

Input Format

First line of input contains T - number of test cases.
Its followed by 2T lines, the first line contains N - the size of the array (of the form 3X + 1)
and second line contains the elements of the array.

Constraints

1 <= T <= 300
1 <= N <= 104
1 <= A[i] <= 109 

Output Format

For each test case, print the number which occurs only once, separated by new line. 

Sample Input 0

2
10
5 7 8 7 7 5 5 9 8 8 
7
10 20 20 30 20 10 10 

Sample Output 0

9
30
 */
public class TrippleTrouble {

	static void solve(int[] arr) {
		int n = arr.length;
		Arrays.sort(arr);
		for (int i = 0; i < n - 2; i = i + 3) {
			if (arr[i] != arr[i + 2]) {
				System.out.println(arr[i]);
				return;
			}
		}
		System.out.println(arr[n - 1]);
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			solve(arr);
		}
		in.close();
	}

}
