package ds.deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class WindowMaximum {

	static final String N = "No";
	public static void main(String[] args) throws Exception {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(1);
		list.add(3);
		
		Collections.max(list);
		
		Map<Integer, String> map = list.stream().collect(Collectors.toMap(i -> i, i -> N, (o, n)->o));
		System.out.println(map);
		
		System.exit(0);
		
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		while(t > 0) {
			int[] array = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int k = array[1];
			int[] arr = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			t--;
		}
		
		int[] arr = new int[]{4, 10, 54, 11, 8, 7, 9};
		int n = arr.length;
		int k = 3;
		int[] karr = new int[n-k+1];
		
		Deque<Integer> deque = new LinkedList<Integer>();
		int sum = 0;
		int e = 0;
		int kIdx = 0;
		
		deque.add(0);
		karr[kIdx] = arr[0];
		
		for(int i = 0; i < k; i++) {
			e = arr[i];
			while(deque.size() > 0 && e >= arr[deque.getLast()]) {
				deque.removeLast();
			}
			deque.add(i);
		}
		karr[kIdx] = arr[deque.getFirst()];
		sum += arr[deque.getFirst()];
		
		for(int i = k; i < n; i++) {
			kIdx++;
			e = arr[i];
			if(deque.getFirst() == i - k) {
				deque.removeFirst();
			}
			while(deque.size() > 0 && e >= arr[deque.getLast()]) {
				deque.removeLast();
			}
			deque.add(i);
			karr[kIdx] = arr[deque.getFirst()];
			sum += arr[deque.getFirst()];
		}
		
		System.out.println(deque);
		System.out.println(Arrays.stream(karr).boxed().collect(Collectors.toList()));
		System.out.println(sum);
	}

}
