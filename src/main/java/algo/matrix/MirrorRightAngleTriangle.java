package algo.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Print mirror image of right-angled triangle using '*'. See examples for more details.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains a single integer N - the size of the pattern.

Constraints

1 <= T <= 100
1 <= N <= 100

Output Format

For each test case, print the test case number as shown, followed by the pattern, separated by newline.

Sample Input 0

4
2
1
5
10
Sample Output 0

Case #1:
*
**
Case #2:
*
Case #3:
*
**
***
****
*****
Case #4:
*
**
***
****
*****
******
*******
********
*********
**********
*/
public class MirrorRightAngleTriangle {
	static void printMirrorRightAngledTriangle(int[] arr, int max) {
		StringBuilder builder = new StringBuilder();
		char[][] mat = new char[max][max];
		int k = max - 1;
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				if (j < k) {
					mat[i][j] = ' ';
				} else {
					mat[i][j] = '*';
				}
			}
			k--;
		}
		for (int a = 0; a < arr.length; a++) {
			System.out.println("Case #" + (a + 1) + ":");
			int n = arr[a];
			if (a > 0 && n == arr[a - 1]) {
				System.out.println(builder);
				continue;
			}
			builder = new StringBuilder();
			int row = n;
			int col = max - row;
			for (int i = 0; i < row; i++) {
				for (int j = col; j < max; j++) {
					builder.append(mat[i][j]);
				}
				builder.append("\n");
			}
			System.out.print(builder);
		}
	}

	public static void main(String[] args) throws Exception {
		int[] arr = null;
		int max = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			arr = new int[t];
			for (int i = 0; i < t; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				if (arr[i] > max)
					max = arr[i];
			}
		}
		printMirrorRightAngledTriangle(arr, max);
	}
}