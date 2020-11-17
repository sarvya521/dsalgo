package algo.bitwise;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class UniqueElementInArray {

	static int maximizingXor(int l, int r) {
		int n = r - l + 1;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = l++;
		}
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		int prev = 0;
		int cur = 0; 
        long combinations = 1L << n;
		for(long i = 0; i < combinations; i++) {
			int index = 0;
			long j = i;
			while(j != 0) {
				if((j & 1) == 1) {
					if(prev == 0) {
						prev = arr[index];
					} else if(cur == 0) {
						cur = arr[index];
					} else {
						prev = cur = 0;
						break;
					}
				}
				j = j >> 1;
				index++;
			}
			if(prev != 0 && cur != 0) {
				System.out.println(prev+","+cur);
			}
			if(prev == r - 1 && cur == r) {
				break;
			}
			prev = cur = 0;
		}
		
		return 0;
    }

    public static void main(String[] args) {
       /* Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int result = maximizingXor(l, r);
        System.out.println(result);
        in.close();*/
    	maximizingXor(10, 15);
    }

}
