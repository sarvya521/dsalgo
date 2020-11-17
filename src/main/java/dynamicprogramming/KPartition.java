package dynamicprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KPartition {

	private static long totalSum = 0;
	private static long highestSum = 0;
	
	static boolean isValidMid(int[] arr, int n, long mid, int k) {
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
	}
	
	static void solve(int[] arr, int n, int k, long lo, long hi) {
		while(lo < hi) {
			long mid = (lo + hi)/2;
			System.out.print("lo="+lo+" hi="+hi+" mid="+mid+" => ");
			if(isValidMid(arr, n, mid, k)) {
				hi = mid;
			} else {
				lo = mid+1;
			}
			System.out.println();
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
		totalSum = sum;
		long lo = 1;
		long hi = sum;
		highestSum = sum;
		/*long mid = (lo + hi)/2;
		System.out.println("mid="+mid+"-"+isValidMid(arr, comSums, n, mid, k));
		hi = mid;
		mid = (lo + hi)/2;
		System.out.println("mid="+mid+"-"+isValidMid(arr, comSums, n, mid, k));*/
		solve(arr, n, k, lo, hi);
		System.out.println("highestSum="+highestSum);
	}

}
