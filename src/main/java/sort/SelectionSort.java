package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SelectionSort {

    /*public static void selectionSort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--)
        {
            int index = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[index]) { 
                    index = j;
                }
            }
            int highestNumber = arr[index];  
            arr[index] = arr[i];
            arr[i] = highestNumber;
            for(int j : arr){
                System.out.print(j+" ");
            }
            System.out.println(" => "+index);
        }
    }*/
	
	static void selectionSort(int[] arr) {
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			int lo = i;
			for(int j = i+1; j < n-1; j++) {
				if(arr[j] < arr[lo]) {
					lo = j;
				}
			}
			int temp = arr[lo];
			arr[lo] = arr[i];
			arr[i] = temp;
		}
	}
     
    public static void main(String a[]){
        int[] arr = {176, -272, -272, -45, 269, -327, -945, 176};
        selectionSort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
