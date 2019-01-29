package twopointer;

import java.util.Arrays;

public class CountTriangles {

	/*static int solve(int[] arr) {
		Arrays.sort(arr); //[20, 23, 59, 67, 72, 83]
        int n = arr.length;
        int count = 0;
        if(n > 2) {
	        for(int a = 0; a < n - 2; a++) {
	        	int k = arr[a];
	        	int i = a + 1;
	        	int j = a + 2;
	    		for(; i < n - 1; i++) {
	    			for(; j < n; j++) {
	    				if(arr[i] + arr[j] > k) {
	    					System.out.println(k + " " + arr[i] + " " + arr[j]);
	    					count++;
	    				}
	    			}
	    		}
	        }
        }
        return count;
	}*/
	
	static int solve(int[] arr) {
		Arrays.sort(arr); //[20, 23, 59, 67, 72, 83]
        int n = arr.length;
        int count = 0;
        if(n > 2) {
	        for(int i = 0; i < n-2; i++) {
	        	int k = i + 2;
	    		for(int j = i + 1; j < n; j++) {
	    			while(k < n && arr[i] + arr[j] > arr[k]) {
	    				k++;
	    			}
	    			count += k - j - 1;
	    		}
	        }
        }
        return count;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{20, 23, 59, 67, 72, 83};
		System.out.println(solve(arr));
		
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
	}
}
