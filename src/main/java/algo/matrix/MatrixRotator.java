package algo.matrix;

import java.util.Scanner;

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
