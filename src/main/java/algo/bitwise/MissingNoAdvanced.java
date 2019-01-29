package algo.bitwise;

import java.util.HashSet;
import java.util.Set;

public class MissingNoAdvanced {
	
	public static int solutionNew(int[] arr) {
		int n = arr.length;
        int[] temp = new int[n+1];
        int i;
		for (i = 0; i < n; i++) {
			if (arr[i] > 0 && arr[i] < n+1 && temp[arr[i]] == 0) {
				temp[arr[i]] = 1;
			}
		}
		for (i = 1; i < n+1; i++) {
			if (temp[i] == 0) {
				return i;
			}
		}
		return n+1;
    }
    
    public static int solution(int[] A) {
    	int n = A.length;
    	int i;
    	int j = 0;
        for(i = 0; i < n; i++) {
           if (A[i] <= 0) {
               int temp;
               temp = A[i];
               A[i] = A[j];
               A[j] = temp;
               j++;  
           }
        }
        int arr2[] = new int[n-j];
        j = 0;
        for(i = j; i < n; i++) {
            arr2[j] = A[i];
            j++;
        }   
        
		for (i = 0; i < j; i++) {
			if (Math.abs(A[i]) - 1 < n && A[Math.abs(A[i]) - 1] > 0) {
				A[Math.abs(A[i]) - 1] = -A[Math.abs(A[i]) - 1];
			}
		}
        
		for (i = 0; i < j; i++) {
			if (A[i] > 0) {
				return i + 1;
			}
		}
        
        return j+1;
    }
    
    public static void main(String[] args) {
		int[] arr = new int[]{2};
		System.out.println(solutionNew(arr));
	}
}
