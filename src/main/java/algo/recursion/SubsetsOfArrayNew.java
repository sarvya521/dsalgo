package algo.recursion;

import java.util.Arrays;

public class SubsetsOfArrayNew {
	
	static void subset(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		int size = 1<<n;
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
		
		sort(sets, size, n, 0);
	}
	
	static void printSets(char[][] sets) {
		int size = sets.length;
		int n = sets[0].length;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < n; j++) {
				if(sets[i][j] != ' ')
					System.out.print((int)sets[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	static char[][] shift(char[][] sets, int start, int end) {
		System.out.println("start="+start+"-end="+end);
		char[] temp = sets[end];
		for(int i = end; i > start; i--) {
			sets[i] = sets[i-1];
		}
		sets[start] = temp;
		return sets;
	}
	
	static char[][] sort(char[][] sets, int len, int n, int start) {
		if(n == 0) {
			System.out.println();
			System.out.println("-----"+n+"-----");
			printSets(sets);
			return sets;
		}
		int end = 0;
		int k = n;
		while(k >= 0 && start < len) {
			sets = sort(sets, len, k - 1, start);
			end = start + (1<<k) - 1;
			sets = shift(sets, start, end);
			start = end + 1;
			k--;
		}
		System.out.println();
		System.out.println("-----"+n+"-----");
		printSets(sets);
		return sets;
	}
 
	public static void main(String[] args) {
		int[] arr = new int[]{57, 96};
		subset(arr);
	}

}
