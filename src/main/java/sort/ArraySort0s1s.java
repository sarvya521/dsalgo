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
		while(i != j) {
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
		Arrays.stream(arr).forEach(k -> System.out.print(k + " "));
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0};
		process(arr);
	}

}
