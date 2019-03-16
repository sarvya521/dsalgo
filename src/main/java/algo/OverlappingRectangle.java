package algo;

import java.util.Scanner;

/*
Given 2 rectangles parallel to coordinate axes, find the area covered by them.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. 
First line of each test case contains 4 integers - xbl, ybl, xtr, ytr - the bottom-left and top-right coordinates of rectangle-1. 
The second line of each test case contains 4 integers - xbl, ybl, xtr, ytr - the bottom-left and top-right coordinates of rectangle-2. 

Constraints

1 <= T <= 10000 
-106 < x,y <= 106 
(xbl, ybl) < (xtr, ytr) 

Output Format

For each test case, print the area covered by the 2 rectangles, separated by newline. 

Sample Input 0

4
2 5 4 6
1 2 5 4
-4 -3 -2 5
-3 -5 1 3
1 0 3 5
2 3 5 8
-2 2 4 4
-3 1 5 5

Sample Output 0

10
42
23
32
 */
public class OverlappingRectangle {
	
	static boolean isOverlap(int a1, int b1, int c1, int d1, int a2, int b2, int c2, int d2) {
		int a3 = Math.max(a1, a2);
		int b3 = Math.max(b1, b2);
		
		int width1 = c1-a1;
		int width2 = c2-a2;
		int width3 = Math.min(a1+width1, a2+width2) - a3;
		
		int hieght1 = d1-b1;
		int hieght2 = d2-b2;
		int hieght3 = Math.min(b1+hieght1, b2+hieght2) - b3;
		
		if(width3 < 0 || hieght3 < 0) {
			return false;
		}
	 
	    return true;
	}

	static int solve(int a1, int b1, int c1, int d1, int a2, int b2, int c2, int d2) {
		int area1 = (c1-a1) * (d1-b1);
		int area2 = (c2-a2) * (d2-b2);
		
		System.out.println(isOverlap(a1, b1, c1, d1, a2, b2, c2, d2));
		
		int a3 = Math.max(a1, a2);
		int b3 = Math.max(b1, b2);
		int c3 = Math.min(c1, c2);
		int d3 = Math.min(d1, d2);
		
		int area3 = (c3-a3) * (d3-b3);
		if(area3 > 0) {
			return area1+area2-area3;
		}
		return area1+area2;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int a1 = in.nextInt();
			int b1 = in.nextInt();
			int c1 = in.nextInt();
			int d1 = in.nextInt();
			int a2 = in.nextInt();
			int b2 = in.nextInt();
			int c2 = in.nextInt();
			int d2 = in.nextInt();
			System.out.println(solve(a1, b1, c1, d1, a2, b2, c2, d2));
		}
		in.close();
    }
}
