package algo.matrix;

import java.util.Scanner;

/*
Given a 2D matrix of size NxN, print the sum of the elements of all its diagonals.

Input Format

First line of input contains T - number of test cases. First line of each test case contains N - size of the matrix. Each of the next N lines contains N integers - the elements of the matrix.

Constraints

1 <= T <= 100
1 <= N <= 100
-100 <= ar[i][j] <= 100

Output Format

For each test case, print the sum of the elements of all the diagonals, separated by newline. Refer samples for more clarity.

Sample Input 0

4
3
-5 0 4
2 8 -6
3 7 1
1
-4
2
5 -2
-4 1
6
-2 -3 -6 -5 50 3
8 7 10 -5 -3 30
6 3 70 9 -20 -7
-9 9 -6 7 3 2
-1 7 7 6 -4 3
8 5 6 -9 40 8

Sample Output 0

4 -6 4 9 3
-4
-2 6 -4
3 80 -15 -29 22 86 51 13 4 4 8

Explanation 0

Test Case 1
Sum of the elements of the 1st diagonal: 4
Sum of the elements of the 2nd diagonal: 0 + -6 = -6
Sum of the elements of the 3rd diagonal: -5 + 8 + 1 = 4
Sum of the elements of the 4th diagonal: 2 + 7 = 9
Sum of the elements of the 5th diagonal: 3

Test Case 2
Sum of the elements of the 1st and only diagonal: -4

Test Case 3
Sum of the elements of the 1st diagonal: -2
Sum of the elements of the 2nd diagonal: 5 + 1 = 6
Sum of the elements of the 3rd diagonal: -4
 */
public class DiagonalTraversalMatrix {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
            int[] sums = new int[(n*2)-1];
		    int mid = ((n*2)-1)/2;
		    int index = 0;
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					int e = in.nextInt();
                    if(r == c) {
                        sums[mid] += e;
                        continue;
                    } else if (c > r) {
                        index = mid - (c - r);
                        sums[index] += e;
                    } else {
                        index = mid + (r - c);
                        sums[index] += e;
                    }
				}
			}
            for(int k = 0; k < sums.length; k++) {
			     System.out.print(sums[k]+" ");
		    }
            System.out.println();
		}
		in.close();
	}
}
