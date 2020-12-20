package sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InsertionSort {

	static void countSort(int[] arr, int M) {
		int n = arr.length;
		int[] cnt = new int[M+1];

		for(int i = 0; i < n; i++) {
			cnt[arr[i]]++;
		}

		int k = 0;
		for(int i = 0; i <= M; i++) {
			if(cnt[i] > 0) {
				for(int j = 0; j < cnt[i]; j++, k++) {
					arr[k] = i;
				}
			}
		}
	}
	
	static void insertionSort(int[] arr) {
		/*int n = arr.length;
		for(int i = 1; i < n; i++) {
			for(int j = i-1; j >= 0; j--) {
				if(arr[j+1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				} else {
					break;
				}
			}
			
		}*/
		int n = arr.length;
		for(int i = 1; i < n; i++) {
			int x = arr[i];
			int j = i - 1;
			for(j = i-1; j >= 0; j--) {
				if(arr[j] > x) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = x;
		}
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
			System.out.println(bubble(arr));
		}
		in.close();*/
        /*int[] input = {154, -109};
        insertionSort(input);*/
    	
    	int[] arr = {5, 3, 4, 7, 2, 8, 6, 9, 1};
        insertionSort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));

		arr = new int[] {1, 2, 1, 1, 3, 4, 4};
		insertionSort(arr);
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
     
    /*public static void insertionSort(int[] array) {
        int n = array.length;
        int[] pos = new int[n-1];
        int p = 0;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
            pos[p++] = i+1;
        }
        for(int i = 0; i < pos.length; i++) {
        	System.out.print(pos[i]+" ");
        }
    }*/
}
