package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KMPStringMatchingAlgo {

	static void getLPS(String pat, int m, int lps[]) {
		int len = 0;
		int i = 1;
		lps[0] = 0;

		while (i < m) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}
	
	static long solve(String pat, String txt) {
		int m = pat.length();
		int n = txt.length();

		int lps[] = new int[m];

		getLPS(pat, m, lps);

		int j = 0;
		int i = 0;
		long res = 0;

		while (i < n) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == m) {
				j = lps[j-1];
				res++;
			} else if (i < n && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i = i + 1;
				}
			}
		}
		return res;
	}
	
	static void solve(int t, String[][] queries) {
		String[] arr = null;
		for(int i = 0; i < t; i++) {
			arr = queries[i];
			System.out.println(solve(arr[0], arr[1]));
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		int i;
		String[][] queries = new String[t][2];
		for(i = 0; i < t; i++) {
			queries[i] = input.readLine().trim().split(" ");
		}
		input.close();
		solve(t, queries);
	}

}
