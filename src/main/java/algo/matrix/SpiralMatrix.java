package algo.matrix;

import java.util.Scanner;

/*
Given a 2D square matrix, print the matrix in a spiral order. Refer examples for more details.

Input Format

First line of input contains T - number of test cases. First line of each test case contains N - size of the matrix [NxN]. Its followed by N lines each containing N integers - elements of the matrix.

Constraints

1 <= T <= 100
1 <= N <= 100
-100 <= ar[i][j] <= 100

Output Format

For each test case, print the matrix in a spiral order, separated by newline.

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

1
1 2 3 4
1 2 3 4 5 6 7 8 9
-44 25 -52 69 -5 -44 -47 -6 90 -20 -21 43 -96 65 -79 17 22 51 27 1 -21 -14 -77 28 -78

*/

public class SpiralMatrix {

	static void printSpiralMatrix(int[][] mat) {
		int n = mat.length;
		int m = n;
		int row = 0;
		int col = 0;
		int i = 0;
		while(row < m && col < n) {
			for(i = col; i < n; i++) {
				System.out.print(mat[row][i]+" ");
			}
			row++;
			for(i = row; i < m; i++) {
				System.out.print(mat[i][n-1]+" ");
			}
			n--;
			if(row < m) {
				for(i = n - 1; i >= col; i--) {
					System.out.print(mat[m-1][i]+" ");
				}
				m--;
			}
			if(col < n) {
				for(i = m - 1; i >= row; i--) {
					System.out.print(mat[i][col]+" ");
				}
				col++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[][] mat = new int[n][n];
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					mat[r][c] = in.nextInt();
				}
			}
			printSpiralMatrix(mat);
            System.out.println();
		}
		in.close();
	}

}
