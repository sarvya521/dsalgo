package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class RepeatedNumbers {
	
	void printRepeating(int arr[], int size) 
    {
        int count[] = new int[size];
        int i;
 
        System.out.println("Repeated elements are : ");
        for (i = 0; i < size; i++) 
        {
            if (count[arr[i]] == 1)
                System.out.print(arr[i] + " ");
            else
                count[arr[i]]++;
        }
    }
	
	static void solve(int[] arr) {
		Arrays.sort(arr);

		int count = 0;
		for(int i = 1; i < arr.length; i++) {
		    if(arr[i] == arr[i - 1]) {
		        System.out.print(arr[i]+" ");
		        count++;
		        if(count == 2) {
		        	System.out.println();
		        	break;
		        }
		    }
		}
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
