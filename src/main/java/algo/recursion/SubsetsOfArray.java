package algo.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubsetsOfArray {
	
	/*static char[][] subset(int[] arr, int n, int size) {
		Arrays.sort(arr);
		char[][] sets = new char[size][n];
		
		char[] a = new char[n];
		for(int i = 0; i < n; i++) {
			a[i] = (char)arr[i];
		}
		sets[0] = a;
		
		for(int i = 1; i < size; i++) {
			int e = i;
			int index = n-1;
			while(index >= 0) {
				if((e & 1) == 1) {
					sets[i][index] = ' ';
				} else {
					sets[i][index] = (char)arr[index];
				}
				index--;
				e = e >> 1;
			}
		}
		
		return sets;
	}

    static void printSets(char[][] sets, int n, int size) {
		for(int i = 1; i < size; i++) {
			for(int j = 0; j < n; j++) {
				if(sets[i][j] != ' ')
					System.out.print((int)sets[i][j]+" ");
			}
			System.out.println();
		}
	}
    
	static char[][] shift(char[][] sets, int start, int end) {
		char[] temp = sets[end];
		for(int i = end; i > start; i--) {
			sets[i] = sets[i-1];
		}
		sets[start] = temp;
		return sets;
	}
    
	static char[][] sort(char[][] sets, int len, int n, int start) {
		if(n == 0) {
			return sets;
		}
		int end = 0;
		int k = n;
		while(k > 0 && start < len) {
			sets = sort(sets, len, k - 1, start);
			end = start + (1<<k) - 1;
			sets = shift(sets, start, end);
			start = end + 1;
			k--;
		}
		return sets;
	}
    
    public static void main(String[] args) {
    	int n = 5;
        int size = 1<<n;
        int[] arr = new int[]{4, 10, 12, 5, 1};
        char[][] sets = subset(arr, n, size);
        sets = sort(sets, size, n, 0);
        printSets(sets, n, size);
    }*/
    
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

	public static boolean solve(int[] arr, int n, int sum, int k, int i) {
		if(sum == k) {
			return true;
		}
		if(sum > k || i == n) {
			return false;
		}
		if (solve(arr, n, sum + arr[i], k, i + 1)) {
			return true;
		}
		if (solve(arr, n, sum, k, i + 1)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		String input = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			for(int i = 0; i < t; i++) {
				String[] iparr = br.readLine().split(" ");
				int n = Integer.parseInt(iparr[0]);
				int k = Integer.parseInt(iparr[1]);
				int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				System.out.println(solve(arr, n, 0, k, 0) ? "YES" : "NO");
			}
		}
	}

}
