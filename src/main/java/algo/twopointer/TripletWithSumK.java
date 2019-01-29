package twopointer;

import java.util.Arrays;

public class TripletWithSumK {
	
	static boolean solve(int[] arr, int k) {
		Arrays.sort(arr);
        int n = arr.length;
        if((arr[n-1] + arr[n-2] + arr[n-3]) < n) {
            return false;
        }
		int l, r;
		for (int i = 0; i < n - 2; i++) {
			l = i + 1;
			r = n - 1;
			while (l < r) {
				if (arr[i] + arr[l] + arr[r] == k) {
					return true;
				} else if (arr[i] + arr[l] + arr[r] < k) {
					l++;
				} else {
					r--;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{12, 45, 52, 6, 21, 645, 234, -100, 14, 575, -80, 112};
		System.out.println(solve(arr, 54));
	}

}
