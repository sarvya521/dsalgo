package algo.matrix;

import java.util.Scanner;

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
