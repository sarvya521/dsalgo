package twopointer;

import java.util.Arrays;

public class PairWithDifference {
	
	static boolean solve(int[] arr, int k) {
		Arrays.sort(arr);
        int n = arr.length;
        if((arr[n-1] - arr[0]) < k) {
            return false;
        }
		int i, j, l;
		l = 1;
		for(i = 0; i < n; i++) {
			for(j = l; j < n; j++) {
				if(Math.abs(arr[i] - arr[j]) == k) {
					return true;
				} else if(arr[j] - arr[i] > k) {
					l = j;
					break;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 20, 40, 100, 80};
		System.out.println(solve(arr, 60));
	}

}
