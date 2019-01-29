package algo.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class TrippleTrouble {

	static void solve(int[] arr) 
    {
		int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n-2; i = i + 3) {
           if(arr[i] != arr[i+2]) {
        	   System.out.println(arr[i]);
        	   return;
           }
        }
        System.out.println(arr[n-1]);
    }
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			solve(arr);
		}
		in.close();
	}

}
