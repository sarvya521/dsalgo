package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SubsequenceSumMeetInTheMiddle {
	
	static long[] partSubequenceSum(int[] input, int n, int c) {
		long[] sums = new long[1<<n];
		for(int i = 0; i<(1<<n); i++) {
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
	
	/*static TreeMap<Long, Long> partSubequenceSum(int[] input, int n, int c) {
		TreeMap<Long, Long> map = new TreeMap<Long, Long>(); 
		Long cnt = null;
		for(int i = 0; i<(1<<n); i++) {
			long sum = 0;
			for(int j = 0; j < n; j++) {
				if((i & (1<<j)) > 0) {
					sum += input[j+c];
				}
			}
			cnt = map.get(sum);
			if(cnt == null) {
				cnt = 0L;
			}
			map.put(sum, cnt+1);
		}
		return map;
	}*/
	
	/*static long solve(int a, int b, int[] input) {
		int size = input.length;
		long[] sumsPart1 = partSubequenceSum(input, size/2, 0);
		TreeMap<Long, Long> sumsPart2 = partSubequenceSum(input, size-size/2, size/2);
		
        
		System.out.println(sumsPart1);
		System.out.println(sumsPart2);
		
        
		long count = 0;
		long s2, s1;
		long v2, v1;
        long firstS1 = sumsPart1.firstKey();
		for(Map.Entry<Long, Long> entry2: sumsPart2.entrySet()) {
			s2 = entry2.getKey();
			v2 = entry2.getValue();
            if(s2+firstS1 > b) {
				break;
			}
			for(Map.Entry<Long, Long> entry1: sumsPart1.entrySet()) {
				s1 = entry1.getKey();
				v1 = entry1.getValue();
				if(s1 > (b-s2)) {
					break;
				} else if(s1 >= (a-s2) && s1 <= (b-s2)) {
					count += v2*v1;
				}
			}
		}		
		
		return count;
	}
	
	static void solve(int t, int[][] queries, int[] A, int[] B) {
		int a, b;
		int[] input = null;
		for(int i = 0; i < t; i++) {
			a = A[i];
			b = B[i];
			input = queries[i];
			System.out.println(solve(a, b, input));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		int i, j, n, a, b;
		String[] arr = null;
		int[] A = new int[t];
		int[] B = new int[t];
		int[][] queries = new int[t][];
		for(i = 0; i < t; i++) {
			arr = input.readLine().trim().split(" ");
			n = Integer.parseInt(arr[0]);
			a = Integer.parseInt(arr[1]);
			b = Integer.parseInt(arr[2]);
			arr = input.readLine().trim().split(" ");
			int[] testCase = new int[n];
			for(j = 0; j < n; j++) {
				testCase[j] = Integer.parseInt(arr[j]);
			}
			queries[i] = testCase;
			A[i] = a;
			B[i] = b;
		}
		input.close();
		solve(t, queries, A, B);
	}*/

}
