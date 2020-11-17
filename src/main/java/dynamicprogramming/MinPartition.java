package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinPartition {
	
	static int minPartition(int[] S, int n, int s1, int s2) {
		if(n < 0) {
			return Math.abs(s1-s2);
		}
		int inc = minPartition(S, n-1, s1+S[n], s2);
		int exc = minPartition(S, n-1, s1, s2+S[n]);
		return Integer.min(inc, exc);
	}

	public static void main(String[] args) {
		/*int[] S = new int[]{10, 20, 15, 5, 25};
		System.out.println(minPartition(S, S.length-1, 0, 0));*/
		
		int[] arr = new int[]{17, 27, 22, 45, 26, 32, 45, 16};
		//int[] arr = new int[]{10};
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		/*List<Integer> list = new ArrayList<>();
		int n = 10000;
		for(int e = 0; e < n; e++) {
			list.add(1000);
		}*/
		
		long sigma = list.stream().mapToLong(Integer::intValue).sum() / 4; //IntStream.of(arr).sum() / 2;
		int n = arr.length;
		
		List<List<Integer>> part = new ArrayList<List<Integer>>();
		List<Long> sums = new ArrayList<Long>();
		List<Integer> p = new ArrayList<>();
		long psum = 0;
		for(int i = 0; i < n; i++) {
			p.add(list.get(i));
			psum = p.stream().mapToLong(Integer::intValue).sum();
			if(i < n-1 && Math.abs(sigma - psum) < Math.abs(sigma - (psum+list.get(i+1)))) {
				part.add(new ArrayList<Integer>(p));
				sums.add(psum);
				p.clear();
			}
		}
		part.add(new ArrayList<Integer>(p));
		sums.add(psum);
		System.out.println(part);
		System.out.println(sums);
	}

}
