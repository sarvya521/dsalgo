package dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistinctElementInWindow {
	
	/*static void solve(int[] arr, int n, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int cnt = 0;
		int e;
		for(int i = 0; i < k; i++) {
			e = arr[i];
			if(map.containsKey(e)) {
				map.put(e, map.get(e)+1);
			} else {
				map.put(e, 1);
				cnt++;
			}
		}
		System.out.println(cnt);
		for(int i = k; i < n; i++) {
			e = arr[i];
			if(map.get(arr[i - k]) == 1) {
				map.remove(arr[i - k]);
				cnt--;
			} else {
				map.put(arr[i - k], map.get(arr[i - k])-1);
			}
			if(map.containsKey(e)) {
				map.put(e, map.get(e)+1);
			} else {
				map.put(e, 1);
				cnt++;
			}
			System.out.println(cnt);
		}
	}*/

	public static void main(String[] args) {
		//int[] arr = new int[]{-2, -4, -2, 4, -2};
		int[] arr = new int[]{-2, -4, -2, 4, -2};
		int n = arr.length;
		int k = 3;
		solve(arr, n, k);
	}
	
	static void solve(int[] arr, int n, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int e;
		Integer c;
		for(int i = 0; i < k; i++) {
			e = arr[i];
			if(map.containsKey(e)) {
				map.put(e, map.get(e)+1);
			} else {
				map.put(e, 1);
			}
		}
		System.out.print(map.size()+" ");
		int start = 0;
		for(int i = k; i < n; i++) {
			start = arr[i - k];
			if(map.get(start) == 1) {
				map.remove(start);
			} else {
				map.put(start, map.get(start)-1);
			}
			e = arr[i];
			c = map.get(e);
			if(c != null) {
				map.put(e, c+1);
			} else {
				map.put(e, 1);
			}
			System.out.print(map.size()+" ");
		}
	}
}
