import java.util.Scanner;
import java.util.Arrays;

public class LexicographicalSubset {
	static char[][] subset(int[] arr, int n, int size) {
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
		char[] temp = sets[end-1];
		for(int i = end-1; i > start; i--) {
			sets[i] = sets[i-1];
		}
		sets[start] = temp;
		return sets;
	}
	
	static char[][] sort(char[][] sets, int len, int n) {
		if(n == 0) {
			return sets;
		}
		sets = sort(sets, len, n-1);
		int m = n;
		int start = 0;
		int end = 0;
		while(m > 0 && start < len) {
			int k = m;
			while(k > 0 && start < len) {
				end = start + (1<<k);
				sets = shift(sets, start, end);
				start = end;
				k--;
			}
			start = start + 2;
			m--;
		}
		return sets;
	}
 
	public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int n = in.nextInt();
         int size = 1<<n;
         int[] arr = new int[n];
         for(int j = 0; j < n; j++) {
             arr[j] = in.nextInt();
         }
         char[][] sets = subset(arr, n, size);
         sets = sort(sets, size, n);
         printSets(sets, n, size);
         System.out.println();
   	}
	}
}
