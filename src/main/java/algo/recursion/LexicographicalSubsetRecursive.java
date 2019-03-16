package algo.recursion;

/*
Given an array of unique integer elements, print all the subsets of the given array in lexicographical order. 

Input Format

First line of input contains T - number of test cases. 
Its followed by 2T lines, the first line contains N - the size of the array 
and second line contains the elements of the array. 

Constraints

1 <= T <= 100
1 <= N <= 10
0 <= A[i] <= 100

Output Format

For each test case, print the subsets of the given array in lexicographical order, separated by new line. 
Print an extra newline between output of different test cases.

Sample Input 0

2
3
5 15 3 
2
57 96 

Sample Output 0

3 
3 5 
3 5 15 
3 15 
5 
5 15 
15 

57 
57 96 
96 
 */
public class LexicographicalSubsetRecursive {
	public static void main(String[] args) {
		String[] set = new String[] { "3", "5", "15"};
		solve(set, 0, "", "");
	}

	public static void solve(String[] set, int i, String subset, String str) {
		if(subset.length() > 0) {
			subset = subset+" "+str;
		} else {
			subset = str;
		}
		if(subset.length() > 0) {
			System.out.println(subset);
		}
		for (; i < set.length; i++) {
			solve(set, i + 1, subset, set[i]); 
		}
	}
}
