package sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BubbleSort {
	
    static int bubble(int array[]) {
        int n = array.length;
        int swaps = 0;
        boolean swapped = false;
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j > i; j--) {
                if (array[j] < array[j-1]) {
                    swapNumbers(j, j-1, array);
                    swaps++;
                    swapped = true;
                }
            }
            if(swapped == false) {
            	break;
            }
            swapped = false;
        }
        return swaps;
    }
  
    static void swapNumbers(int i, int j, int[] array) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
			System.out.println(bubble(arr));
			System.out.println(IntStream.of(arr).boxed().collect(Collectors.toList()));
			System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		}
		in.close();
	}
}
