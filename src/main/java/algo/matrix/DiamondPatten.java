package algo.matrix;

import java.util.Scanner;

public class DiamondPatten {
	
	static void printDiamond(int[] arr) {
		for(int k = 0; k < arr.length; k++) {
			System.out.println("Case #" + (k + 1) + ":");
			int n = arr[k];
			int mid = n / 2;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if( i <= mid) {
						if(j == (mid + i)) {
							System.out.print("*");
							break;
						} else if(j == (mid - i)) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					} else {
						if(j == (n - 1)- (i - mid)) {
							System.out.print("*");
							break;
						} else if(j == (i - mid)) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] arr = new int[t];
		for (int i = 0; i < t; i++) {
			arr[i] = in.nextInt();
		}
		printDiamond(arr);
		in.close();
	}
}
