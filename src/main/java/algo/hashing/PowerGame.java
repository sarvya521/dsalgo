package algo.hashing;

import java.util.Arrays;

public class PowerGame {
	
	public static int solve(int[] a, int[] b, int n) {
		Arrays.sort(a);
		Arrays.sort(b);
		int i , j;
		int k = 0;
		int count = 0;
		if(a[n-1] > b[0]) {
			for(i = 0; i < n; i++) {
				for(j = k; j < n; j++) {
					if(a[i] > b[j]) {
						count++;
						k = j + 1;
						break;
					} else if(a[i] < b[n-1]) {
						break;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int n = 4;
		int[] a = new int[]{1, 1, 1, 1};
		int[] b = new int[]{2, 2, 2, 2};
		long start = System.currentTimeMillis();
		System.out.println(solve(a, b, n)+" - "+(System.currentTimeMillis()-start)+"ms");
	}

}
