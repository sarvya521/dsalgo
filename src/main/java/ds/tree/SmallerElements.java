package ds.tree;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SmallerElements {

	static long smallerElements(int arr[], int n) {
		long smaller_elements[] = new long[n];
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (arr[i] > arr[j]) {
					smaller_elements[i]++;
				}
			}
		}
		System.out.println(Arrays.stream(smaller_elements).boxed().collect(Collectors.toList()));
		return LongStream.of(smaller_elements).sum();
	}

	public static void main(String[] args) {
		int[] arr = new int[] {15, 35, 25, 10, 15, 12};
		int n = arr.length;
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		System.out.println(smallerElements(arr, n));
	}

}
