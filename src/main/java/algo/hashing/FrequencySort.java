package algo.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Map.Entry;

public class FrequencySort {
	
	static void solve(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for(Integer i : arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			} else {
				map.put(i, 1);
			}
		}
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
				Integer k1 = e1.getKey();
				Integer k2 = e2.getKey();
				Integer v1 = e1.getValue();
				Integer v2 = e2.getValue();
				if(v1 != v2) {
					return v1.compareTo(v2);
				} else {
					return k1.compareTo(k2);
				}
			}
		});
		for(Map.Entry<Integer, Integer> entry : list) {
			int e = entry.getKey();
			int c = entry.getValue();
			while(c != 0) {
				System.out.print(e+" ");
				c--;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = new int[] {176, -272, -272, -45, 269, -327, -945, 176};
		solve(arr);
		
		Map<Integer, Long> map = IntStream.of(arr).boxed().collect(Collectors.groupingBy(o -> o, Collectors.counting()));
		System.out.println(map);
		
		map = IntStream.of(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		
		map = map.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Long>>() {
			@Override
			public int compare(Entry<Integer, Long> e1, Entry<Integer, Long> e2) {
				Integer k1 = e1.getKey();
				Integer k2 = e2.getKey();
				Long v1 = e1.getValue();
				Long v2 = e2.getValue();
				if(v1 != v2) {
					return v1.compareTo(v2);
				} else {
					return k1.compareTo(k2);
				}
			}
		}).collect(Collectors.toMap(Map.Entry::getKey,
                Map.Entry::getValue,
                (v1, v2) -> {
                    throw new IllegalStateException();
                },
                LinkedHashMap::new));
		System.out.println(map);
	}

}
