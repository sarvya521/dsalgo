package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberOfValidSubarrays {
	
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	/*static int[] prepareCommulitiveSumArray(int[] arr, int n) {
		int[] coms = new int[n];
		coms[0] = arr[0];
		for(int i = 1; i < n; i++) {
			coms[i] = coms[i-1] + arr[i]; 
		}
		return coms;
	}
	
	static int solve(int[] arr, int n) {
		int[] coms = prepareCommulitiveSumArray(arr, n);
		System.out.println(Arrays.stream(coms).boxed().collect(Collectors.toList()));
		int ans = 0;
		int cnt = 0;
		int e;
		for(int i = 0; i < n; i++) {
			e = coms[i];
			if(map.containsKey(e)) {
				cnt++;
				ans = Math.max(ans, i-map.get(e));
			} else {
				map.put(e, i);
			}
		}
		System.out.println(map);
		System.out.println("Max subarray length="+ans);
		return cnt;
	}*/
	
	static int solve(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int curr_sum = 0;
		for (int i = 0; i < n; i++) {
	        curr_sum += (arr[i] == 0) ? -1 : arr[i];
	        if(map.containsKey(curr_sum)) {
	        	map.put(curr_sum, map.get(curr_sum)+1);
	        } else {
	        	map.put(curr_sum, 1);
	        }
	    }
		int count = 0;
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			int subarrays = entry.getValue();
			if(subarrays > 1) {
				count += ((subarrays * (subarrays - 1)) / 2);
			}
		}
		if(map.size() > 1 && map.containsKey(0)) {
			count += map.get(0);
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 0, 1, 0, 0, 1, 0, 0, 1, 1};
		int n = arr.length;
		System.out.println(solve(arr, n));
	}
}
