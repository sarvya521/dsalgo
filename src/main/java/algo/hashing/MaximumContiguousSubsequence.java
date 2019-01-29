package algo.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaximumContiguousSubsequence {

    static int solve(int[] arr) {
    	Arrays.sort(arr);
        int n = arr.length;
        int l = 1;
        for (int i=0; i<n-1; i++) {
            if(arr[i] == arr[i+1]) {
            	continue;
            }
            int min = arr[i];
            int max = arr[i];
            for (int j=i+1; j<n; j++) {
                if (arr[j] == arr[j-1]) {
                    continue;
                } else if(arr[j]-arr[j-1] > 1) {
                	break;
                }
                max = arr[j];
                int len = Math.abs(max-min)+1;
                if (len > l) {
                	l = len;
                }
            }
        }
        return l;
    }
    
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			System.out.println(solve(arr));
		}
		in.close();*/
    	int[] arr = new int[]{18, -33, 31, 33, 30, -14, 32, 30, 16, 17};
    	System.out.println(solve(arr));
    }
}
