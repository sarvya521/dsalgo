package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FindingFloor {
	
	static void solve(int[] arr, int[] queries) {
		int n = arr.length;
		int m = queries.length;
		
		Map<Integer, Integer> map = new TreeMap<>();
		for(int i = 0; i < m; i++) {
			map.put(queries[i], Integer.MIN_VALUE);
		}
		Arrays.sort(arr);
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		System.out.println(Arrays.stream(queries).boxed().collect(Collectors.toList()));
		
		List<Integer> list = new ArrayList<Integer>(map.keySet());
		
		int i = list.size()-1;
		int j = n-1;
		/*while(j >= 0 && i >= 0) {
			if(list.get(i) == arr[j]) {
				map.put(list.get(i), arr[j]);
				i--;
			} else if(list.get(i) < arr[j]) {
				j--;
			} else if(arr[j] < list.get(i)) {
				map.put(list.get(i), arr[j]);
				i--;
			} else if(list.get(i) < arr[0]) {
				break;
			}
		}*/

		for(int q = 0; q < queries.length; q++) {
			int k = queries[q];
			int ans = Integer.MIN_VALUE;
			int lo = 0, hi = arr.length-1;
			while(lo <= hi) {
				int mid = (lo + hi)/2;
				if(arr[mid] == k) {
					ans = k;
					break;
				}
				if(arr[mid] > k) {
					hi = mid - 1;
				} else {
					ans = arr[mid];
					lo = mid + 1;
				}
			}
			System.out.println("floor("+k+")="+ans);
		}
		
		/*for(i = 0; i < m; i++) {
			System.out.println("floor("+queries[i]+")="+map.get(queries[i]));
		}*/
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{-6, 10, -1, 20, 15, 5};
		int[] orgQueries = new int[]{-1, 10, 8, -10, -4, -10, 10};
		int[] queries = Arrays.copyOf(orgQueries, orgQueries.length); 
		solve(arr, queries);
	}

}
