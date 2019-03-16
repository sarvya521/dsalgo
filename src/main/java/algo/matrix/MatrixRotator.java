package algo.matrix;

import java.util.Scanner;

/*
Given a 2D square matrix, rotate the matrix by 90 degrees in clockwise manner and then print the rotated matrix.

Input Format

First line of input contains T - number of test cases. First line of each test case contains N - size of the matrix [NxN]. Its followed by N lines each containing N integers - elements of the matrix.

Constraints

1 <= T <= 100
1 <= N <= 100
-100 <= ar[i][j] <= 100

Output Format

For each test case, print the rotated matrix, separated by newline.

Sample Input 0

4
1
1
2
1 2
4 3
3
1 2 3
8 9 4
7 6 5
5
-44 25 -52 69 -5
17 22 51 27 -44
-79 28 -78 1 -47
65 -77 -14 -21 -6
-96 43 -21 -20 90

Sample Output 0

Test Case #1:
1
Test Case #2:
4 1
3 2
Test Case #3:
7 8 1
6 9 2
5 4 3
Test Case #4:
-96 65 -79 17 -44
43 -77 28 22 25
-21 -14 -78 51 -52
-20 -21 1 27 69
90 -6 -47 -44 -5
 */
public class MatrixRotator {
	
	static void rotate(int[][] arr) {
		int n = arr.length;
		for(int r = 0; r < n; r++) {
			int i = n - 1;
			int j = r;
			for(int c = 0; c < n; c++) {
				System.out.print(arr[i][j]+" ");
				i--;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println("Case #" + (i + 1) + ":");
			int n = in.nextInt();
			int[][] mat = new int[n][n];
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					mat[r][c] = in.nextInt();
				}
			}
			rotate(mat);
		}
		in.close();
	}

}
