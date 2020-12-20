package sort;

import java.util.Arrays;

/**
 * Given array with only 0s and 1s, sort it
 * 
 * @author sarvesh
 */
public class ArraySort0s1s {

	private static void process(int[] arr) {
		int n = arr.length;
		int i = 0;
		int j = n-1;
		int temp = 0;
		while(i != j && i < n && j < n) {
			if(arr[i] == 1 && arr[j] == 0) {
				arr[j] = 1;
				arr[i] = 0;
				i++;
				j--;
			} else if(arr[i] == 1) {
				j--;
			} else {
				i++;
			}
		}
		/*for(int k = 0; k < n/2; k++) {
			if(arr[i] > arr[j]) {
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
				j--;
			} else if(arr[i] == 1) {
				j--;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}*/
		Arrays.stream(arr).forEach(k -> System.out.print(k + " "));
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {0, 0 , 0};
		process(arr);
	}

}
