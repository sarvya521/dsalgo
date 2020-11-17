package algo.matrix;

import java.util.Scanner;

/*
Given 2 matrices, find the product.

Input Format

First line of input contains T - number of test cases. First line of each test case contains N1, M1 - size of the 1st matrix. Its followed by N1 lines each containing M1 intergers - elements of the 1st matrix. The next line contains N2, M2 - size of the 2nd matrix. Its followed by N2 lines each containing M2 intergers - elements of the 2nd matrix. Note that M1 = N2.

Constraints

1 <= T <= 100
1 <= N1,M1,N2,M2 <= 50
-100 <= mat[i][j] <= 100

Output Format

For each test case, print the resultant product matrix, separated by newline.

Sample Input 0

2
2 2
1 2
3 -1
2 3
1 -2 3
2 3 -1
2 3
27 29 53
-28 49 -24
3 4
23 52 -38 72
-64 15 -59 -10
-75 43 10 25

Sample Output 0

5 4 1
1 -9 10
-5210 4118 -2207 2979
-1980 -1753 -2067 -3106
 */
public class ProductOfMatrices {
	
	static void product(long[][] mat1, long[][] mat2) {
		int n1 = mat1.length;
		int m1 = mat1[0].length;
		int m2 = mat2[0].length;
		int i = 0;
		int j = 0;
		int l = 0;
		long p = 0;
		for(i = 0; i < n1; i++) {
			for(j = 0; j < m2; j++) {
				for(l = 0; l < m1; l++) {
					p += mat1[i][l]*mat2[l][j];
				}
				System.out.print(p+" ");
				p = 0;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n1 = in.nextInt();
			int m1 = in.nextInt();
			long[][] mat1 = new long[n1][m1];
			for(int r = 0; r < n1; r++) {
				for(int c = 0; c < m1; c++) {
					mat1[r][c] = in.nextInt();
				}
			}
			int n2 = in.nextInt();
			int m2 = in.nextInt();
			long[][] mat2 = new long[n2][m2];
			for(int r = 0; r < n2; r++) {
				for(int c = 0; c < m2; c++) {
					mat2[r][c] = in.nextInt();
				}
			}
			product(mat1, mat2);
            System.out.println();
		}
		in.close();
	}

}
