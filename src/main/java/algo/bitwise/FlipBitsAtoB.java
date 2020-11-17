package algo.bitwise;

/*
You are given two numbers A and B. 
Write a program to count the number of bits to be flipped to change the number A to the number B. 
Flipping a bit of a number means changing a bit from 1 to 0 or vice versa.

Input Format

First line of input contains T - number of test cases. 
Each of the next T lines contains 2 integer A and B, separated by space. 

Constraints

1 <= T <= 100000 
0 <= N <= 109

Output Format

For each test case, print the number of bit flips required to convert A to B, separated by new line.

Sample Input 0

4
20 10
16 8
1 153
549 24

Sample Output 0

4
2
3
6
 */
public class FlipBitsAtoB {

	static int solve(int a, int b) {
		int n = a^b;
		int count  = 0;
		while(n != 0) {
			if((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(solve(1, 153));
	}

}
