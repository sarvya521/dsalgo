package algo.array.prefixsum;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SubarrayWithinArray {

	static long[] prefixSum(int[] arr) {
		int n = arr.length;
		long[] coms = new long[n+1];
		coms[0] = 0;
		for(int i = 1; i <= n; i++) {
			coms[i] = coms[i-1] + arr[i-1];
		}
		return coms;
	}
	
	public static int findArray(int[] array, int[] subArray) {
		if(array == null || subArray == null || array.length < subArray.length) {
			return -1;
		}
		
		//System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
		//System.out.println(Arrays.stream(subArray).boxed().collect(Collectors.toList()));
		
		int n = array.length;
		int m = subArray.length;
		
		long[] arrayComs = prefixSum(array);
		long[] subArrayComs = prefixSum(subArray);
		//System.out.println(Arrays.stream(arrayComs).boxed().collect(Collectors.toList()));
		//System.out.println(Arrays.stream(subArrayComs).boxed().collect(Collectors.toList()));
		
		long totalSubArraySum = subArrayComs[m];
		
		long a = 0;
		int i, j, idx = -1;
		for(i = m; i <= n; i++) {
			a = arrayComs[i] - arrayComs[i-m];
			if(a >= totalSubArraySum) {
				for(j = 0; j < m; j++) {
					if(subArray[j] != array[i-m+j]) {
						break;
					}
				}
				if(j == m) {
					idx = i-m;
				}
			}
		}
		return idx;
	}
	
	public static void main(String[] args) {
		System.out.println(findArray(new int[]{3, 5, 1, 8, 2, 1, 8, 2, 1}, new int[]{8,2,1}));
		System.exit(0);
	}

}
