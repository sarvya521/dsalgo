package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-of-pairs/problem

Given an array of integers and a number K, check if there exist a pair of indices i,j s.t. a[i] + a[j] = K and i!=j.

Input Format

First line of input contains T - number of test cases.
Its followed by 2T lines, first line of each test case contains N - size of the array and K,
and the next line contains N integers - the elements of the array. 

Constraints

30 points 
1 <= T <= 100 
2 <= N <= 1000 

70 points 
1 <= T <= 300 
2 <= N <= 10000 

General Constraints 
-108 <= K <= 108 
-108 <= ar[i] <= 108 

Output Format

For each test case, print "True" if such a pair exists, "False" otherwise, separated by newline. 

Sample Input 0

3
5 -15
-30 15 20 10 -10 
2 20
10 10 
4 7
-4 0 10 -7 
Sample Output 0

True
True
False
 */
public class SumOfPairs {

	static void merge(int[] arr, int lo, int mid, int hi) {
//		System.out.println("merge lo="+lo+" mid="+mid+" hi="+hi);
		int[] tmp = new int[hi - lo + 1];
		int p1 = lo, p2 = mid+1, index = 0;
		while(p1 <= mid && p2 <= hi) {
			if(arr[p1] < arr[p2]) {
				tmp[index++] = arr[p1++];
			} else {
				tmp[index++] = arr[p2++];
			}
		}
		while(p1 <= mid) {
			tmp[index++] = arr[p1++];
		}
		while(p2 <= hi) {
			tmp[index++] = arr[p2++];
		}
		for(int i = lo; i <= hi; i++) {
			arr[i] = tmp[i-lo];
		}
	}

	static void MS(int[] arr, int lo, int hi) {
//		System.out.println("MS lo="+lo+" hi="+hi);
		if (lo == hi) {
			return;
		}
		int mid = (lo + hi) / 2;
		MS(arr, lo, mid);
		MS(arr, mid + 1, hi);
		merge(arr, lo, mid, hi);
	}

	static boolean solve(int[] arr, int n, int k) {
		MS(arr, 0, n-1);
//		Arrays.stream(arr).forEach(e -> System.out.print(e+" "));
//		System.out.println();
		int p1 = 0;
		int p2 = n - 1;
		int sum = 0;
		while (p1 != p2) {
			sum = arr[p1] + arr[p2];
			if (sum == k) {
				return true;
			}
			if (sum < k) {
				p1++;
			} else {
				p2--;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				final String[] ip = br.readLine().split(" ");
				int n = Integer.parseInt(ip[0]);
				int k = Integer.parseInt(ip[1]);
				final int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				System.out.println(solve(arr, n, k) ? "True" : "False");
			}
		}
	}

}
