package algo.array;

import java.util.Scanner;

/*
Given an array of integers, find the sum of the elements of the given array.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array and second line contains the elements of the array.

Constraints

1 <= T <= 100
1 <= N <= 1000
1 <= ar[i] <= 1e15

Output Format

For each test case, print the sum of the elements of the array, separated by new line.

Sample Input 0

2
3
5 15 3
2
70 100

Sample Output 0

23
170
 */
public class ArraySum {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int size = in.nextInt();
			long sum = 0;
			for(int j = 0; j < size; j++) {
				sum += in.nextLong(); 
			}
			System.out.println(sum);
		}
		in.close();
	}
}
