package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubsequenceSumMeetInTheMiddle {

	private static int lowerBound(long[] arr, long key) {
		// int idx = Arrays.binarySearch(arr, key);
		// if(idx > -1) {
		//     return idx;
		// }
		// return (Math.abs(idx) - 2);

		int lo = 0;
		int hi = arr.length;
		while(lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if(arr[mid] < key) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

	private static int upperBound(long[] arr, long key) {
		// int idx = Arrays.binarySearch(arr, key);
		// if(idx > -1) {
		//     return idx;
		// }
		// return (Math.abs(idx) - 1);

		int lo = 0;
		int hi = arr.length;
		while(lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] > key) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

	private static long[] partSubequenceSum(int[] input, int n, int c) {
		int m = 1<<n;
		long[] sums = new long[m];
		for(int i = 0; i<m; i++) {
			long sum = 0;
			for(int j = 0; j < n; j++) {
				if((i & (1<<j)) > 0) {
					sum += input[j+c];
				}
			}
			sums[i] = sum;
		}
		return sums;
	}

	private static int solve(int a, int b, int[] arr) {
		int n = arr.length;
		long[] sumsPart1 = partSubequenceSum(arr, n/2, 0);
		long[] sumsPart2;
		if(n % 2 != 0) {
			sumsPart2 = partSubequenceSum(arr, n/2 + 1, n/2);
		} else {
			sumsPart2 = partSubequenceSum(arr, n/2, n/2);
		}
		Arrays.sort(sumsPart2);

		int ans = 0;
		for (long l : sumsPart1) {
			int lo = lowerBound(sumsPart2, a-l);
			int hi = upperBound(sumsPart2, b-l);
			ans+=(hi-sumsPart2[0])-(lo-sumsPart2[0]);
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		StringBuilder builder = new StringBuilder();
		try(BufferedReader input = new BufferedReader (new InputStreamReader(System.in))) {
			int t = Integer.parseInt(input.readLine());
			for(int i = 0; i < t; i++) {
				String[] ip = input.readLine().split(" ");
				int n = Integer.parseInt(ip[0]);
				int a = Integer.parseInt(ip[1]);
				int b = Integer.parseInt(ip[2]);
				final int[] arr = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				builder.append(solve(a, b, arr)).append(System.lineSeparator());
			}
		}
		System.out.println(builder);
	}

}
