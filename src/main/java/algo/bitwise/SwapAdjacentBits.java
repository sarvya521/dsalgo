package algo.bitwise;

/*
Given a number, swap the adjacent bits in the binary representation of the number, 
and print the new number formed after swapping. 

Input Format

First line of input contains T - number of test cases. Each of the next T lines contains a number N. 

Constraints

1 <= T <= 100000 
0 <= N <= 109 

Output Format

For each test case, print the new integer formed after swapping adjacent bits, separated by new line. 

Sample Input

4
10
7
43
100

Sample Output

5
11
23
152

Explanation

Test Case 1

Binary Representation of 10: 000...1010
After swapping adjacent bits: 000...0101 (5)

Test Case 2

Binary Representation of 7: 000...0111
After swapping adjacent bits: 000...1011 (11)
 */
public class SwapAdjacentBits {
	
	static long solve(int n) {
		return ((n & 715827882) >> 1) | ((n & 1431655765) << 1);
	}

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("101010101010101010101010101010", 2));
		System.out.println(Integer.parseInt("01010101010101010101010101010101", 2));
		System.out.println(solve(10));  // 1010 0101
		System.out.println(solve(7));   // 111 1011
		System.out.println(solve(43));  // 101011 010111
		System.out.println(solve(100)); // 01100100 10011000 
	}

}
