package matrix;

import java.util.Scanner;

/*
 * 0  1  2  3 
 * 4  5  6  7
 * 8  9  10 11
 * 12 13 14 15
 * 
 * 0 1 2 3 7 11 15 14 13 12 8  4  5  6  10 9
 * 0 1 2 3 4  5  6  7  8  9 10 11 12 13 14 15
 * 
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 
 * 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * 
 * 00 01 02 03
 * 10 11 12 13
 * 20 21 22 23
 * 30 31 32 33
 * 
 * 00 01 02 03 13 23 33 32 31 30 20 10 11 12 22 21
 *  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
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
