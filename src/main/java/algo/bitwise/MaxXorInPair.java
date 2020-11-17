package algo.bitwise;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class MaxXorInPair {
	
	static int maximizingXorNew2(int l, int r) {
		long start = System.currentTimeMillis();
		int maxXor = 0;
		int mid = ((r+l)/2)+1;
		for(int i = l; i <= r; i++) {
			int k = r;
			while(k > i) {
				int xor = i^k;
				if(xor > maxXor) {
					maxXor = xor;
				}
				k--;
			}
		}
		System.out.println((System.currentTimeMillis() - start) + " ms");
		return maxXor;
	}
	
	static int maximizingXorNew(int l, int r) {
		long start = System.currentTimeMillis();
		int maxXor = 0;
		while(r > l) {
			int xor = l^r;
			if(xor > maxXor) {
				maxXor = xor;
			}
			r--;
		}
		System.out.println((System.currentTimeMillis() - start) + " ms");
		return maxXor;
	}

	static int maximizingXor(int l, int r) {
		long start = System.currentTimeMillis();
		int maxXor = 0;
		int n = r - l + 1;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = l++;
		}
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
				//System.out.println(prev+","+cur);
				int xor = prev^cur;
				if(xor > maxXor) {
					maxXor = xor;
				}
			} else if(prev != 0 && cur == 0) {
				//System.out.println(prev+","+prev);
				int xor = prev^prev;
				if(xor > maxXor) {
					maxXor = xor;
				}
			}
			if(prev == r - 1 && cur == r) {
				break;
			}
			prev = cur = 0;
		}
		System.out.println((System.currentTimeMillis() - start) + " ms");
		return maxXor;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int result = maximizingXorNew(l, r);
        System.out.println(result);
        result = maximizingXorNew2(l, r);
        System.out.println(result);
        in.close();
    }

}
