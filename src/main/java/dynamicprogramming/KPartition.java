package dynamicprogramming;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
1. Done
2. Done
3. Not Done
4. Not Done
5. Not Done
6. Done
7. 1 problem done
8. Not Done
9. tried couple of time. Will work on it one more time else I will take help from mentors for directions
10. Not Done
*/

public class KPartition {

	/*static boolean isValidMid(int[] arr, int n, long mid, int k) {
		long[] parts = new long[k];
		long finalSum = 0;
		long highSum = 0;
		int i = 0;
		int j = 0;
		long sum = 0;
		long partSum = 0;
		for(i = 0; i < n && j < k; i++) {
			sum += arr[i];
			if(sum > mid) {
				partSum = sum-arr[i];
				parts[j] = partSum;
				if(partSum > highSum) {
					highSum = partSum;
				}
				finalSum += partSum;
				sum = arr[i];
				j++;
			}
		}
		if(j < k && sum <= mid) {
			parts[j] = sum;
			if(sum > highSum) {
				highSum = sum;
			}
			finalSum += sum;
		}
		if(finalSum < totalSum) {
			return false;
		}
		if(highSum < highestSum) {
			highestSum = highSum;
		}
		System.out.println(Arrays.stream(parts).boxed().collect(Collectors.toList()));
		return true;
	}*/

	private static boolean isValidMid(int[] arr, int n, long mid, int k) {
		int sum = 0;
		int p = k;
		for (int i = 0; i < n; i++) {
			if(arr[i] > mid) {
				return false;
			}
			if (sum + arr[i] > mid) {
				sum = 0;
				p--;
				if(p < 1) {
					return false;
				}
			} else {
				sum += arr[i];
			}
		}
		return true;
	}

	private static int arraySum(int[] arr, int n) {
		int ans = 0;
		for(int e : arr) {
			ans += e;
		}
		return ans;
	}

	private static int solve(int[] arr, int n, int k) {
		int sum = arraySum(arr, n);
		int lo = sum / k;
		int hi = sum;
		int mid = 0;
		int ans = 0;
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (isValidMid(arr, n, mid, k)) {
				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return ans;
	}

	private static int ANS = Integer.MAX_VALUE;

	private static void solve(int[] arr, int n, int k, int i, int msum) {
		//System.out.println("k="+k+" i="+i+" msum="+msum+" ans="+ANS);
		if(k == 1 || i == n-1) {
			int csum = IntStream.range(i, n).map(j -> arr[j]).sum();
			int cans = Math.max(msum, csum);
			ANS = Math.min(ANS, cans);
			return;
		}
		int sum = 0;
		for(int j = i; j < n; j++) {
			sum += arr[j];
			solve(arr, n, k-1, j+1, Math.max(msum, sum));
		}
	}
	
	public static void main(String[] args) {
//		int[] arr = new int[]{1, 10, 13, 4, 5, 12, 23, 12, 18, 8};
//		//int[] arr = new int[]{74, 24, 61, 81, 66, 76, 51};
//		//int[] arr = new int[]{17, 27, 22, 45, 26, 32, 45, 16};
//		int k = 3;
//		int n = arr.length;
//		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
//		long sum = list.stream().mapToLong(Integer::intValue).sum();
//		totalSum = sum;
//		long lo = 1;
//		long hi = sum;
//		highestSum = sum;
//		/*long mid = (lo + hi)/2;
//		System.out.println("mid="+mid+"-"+isValidMid(arr, comSums, n, mid, k));
//		hi = mid;
//		mid = (lo + hi)/2;
//		System.out.println("mid="+mid+"-"+isValidMid(arr, comSums, n, mid, k));*/
//		solve(arr, n, k, lo, hi);
//		System.out.println("highestSum="+highestSum);

		int[] arr = new int[]{74, 61};
		int n = arr.length;
		int k = 2;
		solve(arr, n, k, 0, 0);
		System.out.println("ans="+ANS);

		int ans = solve(arr, n, k);
		System.out.println("ans="+ans);
	}

}
