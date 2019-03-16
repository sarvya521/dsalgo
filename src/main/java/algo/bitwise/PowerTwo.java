package algo.bitwise;

/*
Given a number, check if it is a power of 2. 

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line containing a single positive integer. 

Constraints

1 <= T <= 10000 
1 <= N <= 1018 

Output Format

For each test case, print "True" or "False", separated by new line. 

Sample Input 0

5
1
8
10
25
512

Sample Output 0

True
True
False
False
True
 */
public class PowerTwo {
	static boolean check(long n) {
		if((n & (n-1)) == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(check(0));
		System.out.println(check(16));
		System.out.println(check(25));
		System.out.println(check(512));
	}
}
