package sort;

import java.util.Arrays;

public class SumOfPairs {

	static boolean solve(int[] arr, int k) {
		Arrays.sort(arr); // -30 -10 10 15 20
		int n = arr.length;
		int p1 = 0;
		int p2 = n-1;
		int sum = 0;
		while(p1 != p2) {
			sum = arr[p1]+arr[p2];
			if(sum == k) {
				return true;
			}
			if(sum < k) {
				p1++;
			} else {
				p2--;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{-30, 15, 20, 10, -10};
		int k = -15;
		System.out.println(solve(arr, k));
	}

}
