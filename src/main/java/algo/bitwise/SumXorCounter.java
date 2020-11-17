package algo.bitwise;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumXorCounter {
	
	static long nextPowTwo(long n) {
		int highBitIndex = 0;
		int index = 0;
		while(n!=0) {
			if((n & 1) == 1) {
				highBitIndex = index;
			}
			index++;
			n = n >> 1;
		}
		return 1L<<(highBitIndex+1);
	}
	
	static long solveNew(long n) {
		long start = System.currentTimeMillis();
		long count = 0;
        while(n != 0){
        	if((n&1) == 0) {
        		count++;
        	}
            n=n/2; 
        }
        count = 1L<<count;
        System.out.println(System.currentTimeMillis() - start +"ms");
        return count;
	}

	static long solve(long n) {
		long start = System.currentTimeMillis();
		if(n == 0 || ((n+1)&(n))==1) {
            return 1;
        } else if(n < 3 || (n&(n-1))==0) {
			return n;
		}
		int count = 1;
		long i = 1;
		long j = n;
		long end = nextPowTwo(n);
		while(i < end) {
			j = n + i;
			if(j == (n ^ i)) {
				count++;
			}
			i++;
		}
		System.out.println(System.currentTimeMillis() - start +"ms");
		return count;
    }
	
	static int findMinDiff(int[] A) {
		int n = A.length;
		Arrays.sort(A);

		int diff = Integer.MAX_VALUE;

		for (int i = 0; i < n - 1; i++) {
			if (A[i + 1] - A[i] < diff) {
				diff = A[i + 1] - A[i];
			}
		}

		return diff;
	}
	
	public static int solution(int[] A) {
        int n = A.length;
        java.util.Arrays.sort(A);
        
        int k = Integer.MAX_VALUE;
        
        for (int i = 0; i < n - 1; i++) {
			if (A[i + 1] - A[i] < k) {
				k = A[i + 1] - A[i];
			}
		}
		
		return k;
        
    }
	
	public static String solution(String s) {
		String newString = s.replace("AA", "").replace("BB", "").replace("CC", "");

		if (newString.equals(s)) {
			return newString;
		} else {
			return solution(newString);
		}
	}

    public static void main(String[] args) {
    	/*System.out.println(Long.highestOneBit(11)<<1);
    	System.out.println(nextPowTwo(11));*/
        /*Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = solve(n);*/
        /*long result = solve(1000000000000000L);
        System.out.println(result);
        result = solveNew(1000000000000000L);
        System.out.println(result);*/
    	/*System.out.println((1<<31)-1);
    	System.out.println(Integer.MAX_VALUE);
    	int[] a = new int[]{8, 24, 3, 20, 1, 17};
    	System.out.println(solution(a));
    	System.out.println(findMinDiff(a));*/
    	System.out.println(solution("ACCAABBC"));
    }

}
