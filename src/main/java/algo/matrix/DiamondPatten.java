package algo.matrix;
/*
Print hollow diamond pattern using '*'. See examples for more details.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains a single odd integer N - the size of the diamond.

Constraints

1 <= T <= 100
3 <= N <= 201

Output Format

For each test case, print the test case number as shown, followed by the diamond pattern, separated by newline.

Sample Input 0

4
3
7
5
15
Sample Output 0

Case #1:
 *
* *
 *
Case #2:
   *
  * *
 *   *
*     *
 *   *
  * *
   *
Case #3:
  *
 * *
*   *
 * *
  *
Case #4:
       *
      * *
     *   *
    *     *
   *       *
  *         *
 *           *
*             *
 *           *
  *         *
   *       *
    *     *
     *   *
      * *
       *
*/

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

	private static void process(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			diamond(arr[i]);
		}
	}

	private static void diamond(int n) {
		int mid = n/2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i <= mid) {
					if(j == mid + i) {
						System.out.print("*");
					} else if(j == mid - i) {
						System.out.println("*");
					} else {
						System.out.println(" ");
					}
				} else {
					if(j == mid + i) {
						System.out.print("*");
					} else if(j == mid - i) {
						System.out.println("*");
					} else {
						System.out.println(" ");
					}
				}
			}
		}
	}
}
