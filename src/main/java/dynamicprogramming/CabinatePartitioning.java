package dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CabinatePartitioning {

	private static long TARGET_SUM = 0;
	private static long highestSum = 0;
	private static boolean validPartitionFound = false;
	
	static long[] getCommulitiveSum(int[] arr, int n) {
		long[] comSums = new long[n+1];
		comSums[0] = 0;
		for(int i = 1; i <= n; i++) {
			comSums[i] =  comSums[i-1] + arr[i-1]; 
		}
		return comSums;
	}
	
	static boolean isValidMid(int[] arr, long[] comSums, int n, long mid, int k) {
		long[] parts = new long[k];
		long finalSum = 0;
		long highSum = 0;
		int i = 0;
		int j = 0;
		int x = 0;
		long sum = 0;
		long partSum = 0;
		for(i = 0; i < n && j < k; i++) {
			sum = comSums[i+1]-comSums[x];
			if(sum > mid) {
				partSum = sum-arr[i];
				parts[j] = partSum;
				if(partSum > highSum) {
					highSum = partSum;
				}
				finalSum += partSum;
				x = i;
				sum = comSums[i+1]-comSums[x];
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
		if(finalSum < comSums[n]) {
			return false;
		}
		if(highSum == highestSum) {
			validPartitionFound = true;
		}
		if(highSum < highestSum) {
			highestSum = highSum;
		}
		System.out.println(Arrays.stream(parts).boxed().collect(Collectors.toList()));
		return true;
	}
	
	static void solve(int[] arr, long[] comSums, int n, int k, long lo, long hi) {
		while(lo < hi) {
			long mid = (lo + hi)/2;
			System.out.print("lo="+lo+" hi="+hi+" mid="+mid+" => ");
			if(isValidMid(arr, comSums, n, mid, k)) {
				hi = mid;
			} else {
				lo = mid+1;
			}
			System.out.println();
			//solve(arr, comSums, n, k, lo, hi);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1, 10, 13, 4, 5, 12, 23, 12, 18, 8};
		//int[] arr = new int[]{74, 24, 61, 81, 66, 76, 51};
		//int[] arr = new int[]{17, 27, 22, 45, 26, 32, 45, 16};
		int k = 3;
		int n = arr.length;
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		long sum = list.stream().mapToLong(Integer::intValue).sum();
		TARGET_SUM = sum / k;
		long lo = 1;
		long hi = sum;
		long[] comSums = getCommulitiveSum(arr, n);
		System.out.println(Arrays.stream(comSums).boxed().collect(Collectors.toList()));
		highestSum = comSums[n];
		/*long mid = (lo + hi)/2;
		System.out.println("mid="+mid+"-"+isValidMid(arr, comSums, n, mid, k));
		hi = mid;
		mid = (lo + hi)/2;
		System.out.println("mid="+mid+"-"+isValidMid(arr, comSums, n, mid, k));*/
		solve(arr, comSums, n, k, lo, hi);
		System.out.println("highestSum="+highestSum);
	}

}
