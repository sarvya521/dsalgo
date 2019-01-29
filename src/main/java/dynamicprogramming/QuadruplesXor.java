package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuadruplesXor {
	
	static int solve(int n, List<Integer> list1, List<Integer> list2, List<Integer> list3, List<Integer> list4) {
		List<Integer> set1 = new ArrayList<Integer>();
		//set1.add(Integer.MIN_VALUE);
		List<Integer> set2 = new ArrayList<Integer>();
		int i, j, a, b;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer c = null;
		for(i = 0; i < n; i++) {
			for(j = 0; j < n; j++) {
				a = list1.get(i)^list2.get(j);
                b = list3.get(i)^list4.get(j);
				//set1.add(a);
				set2.add(b);
				
				c = map.get(a);
				if(c != null) {
					map.put(a, c+1);
				} else {
					map.put(a, 1);
				}
			}
		}
		//set2.retainAll(set1);
		//set1.retainAll(set2);
		//Collections.sort(set1);
		//Collections.sort(set2);
		
		/*System.out.println(set1);
		System.out.println(set2);*/

		
		System.out.println(map);
		System.out.println(set2);
		
		int cnt = 0;
		for(int e : set2) {
			cnt += map.containsKey(e) ? map.get(e) : 0;
		}
		return cnt;
	}

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>();
		
		
		list1.add(49);list1.add(73);list1.add(58);list1.add(30);list1.add(72);list1.add(44);list1.add(78);list1.add(23);
		
		list2.add(9);list2.add(40);list2.add(65);list2.add(92);list2.add(42);list2.add(87);list2.add(3);list2.add(27);
		
		list3.add(29);list3.add(40);list3.add(12);list3.add(3);list3.add(69);list3.add(9);list3.add(57);list3.add(60);
		
		list4.add(33);list4.add(99);list4.add(78);list4.add(16);list4.add(35);list4.add(97);list4.add(26);list4.add(12);
		
		/*
		list1.add(11);list1.add(88);list1.add(64);list1.add(38);
		
		list2.add(11);list2.add(88);list2.add(64);list2.add(38);
		
		list3.add(16);list3.add(75);list3.add(77);list3.add(92);
		
		list4.add(16);list4.add(75);list4.add(77);list4.add(92);
		*/
		
		/*
		list1.add(1);list1.add(2);list1.add(3);list1.add(4);
		
		list2.add(2);list2.add(3);list2.add(5);list2.add(6);
		
		list3.add(7);list3.add(8);list3.add(9);list3.add(10);
		
		list4.add(2);list4.add(7);list4.add(10);list4.add(3);
		*/
		
		long start = System.currentTimeMillis();
		System.out.println(solve(list1.size(), list1, list2, list3, list4)+" - "+(System.currentTimeMillis()-start)+"ms");
	}

}

