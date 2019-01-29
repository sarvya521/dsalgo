package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CollectingWater {
	
	/*static int solve(int[] arr) {
		int n = arr.length;
		int left[] = new int[n];
		int right[] = new int[n];
		int water = 0;
		left[0] = arr[0];
        for (int i = 1; i < n; i++) {
           left[i] = Math.max(left[i-1], arr[i]);
        }
        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
           right[i] = Math.max(right[i+1], arr[i]);
        }
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i],right[i]) - arr[i];
        }
		return water;
	}*/
	
	static int solve(int[] arr) {
		int n = arr.length;
		int result = 0;
		int left_max = 0, right_max = 0;
		int lo = 0, hi = n - 1;
		while (lo <= hi) {
			if (arr[lo] < arr[hi]) {
				if (arr[lo] > left_max) {
					left_max = arr[lo];
				} else {
					result += left_max - arr[lo];
				}
				lo++;
			} else {
				if (arr[hi] > right_max) {
					right_max = arr[hi];
				} else {
					result += right_max - arr[hi];
				}
				hi--;
			}
		}
		return result;
	}
	
	static void solve(String[][] queries, int t) {
		int[] arr = null;
		String[] query = null;
		for(int i = 0; i < t; i++) {
			query = queries[i];
			arr = Arrays.stream(query).mapToInt(Integer::parseInt).toArray();
			System.out.println(solve(arr));
		}
	}

	public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		String[][] queries = new String[t][];
		for(int i = 0; i < t; i++) {
			input.readLine();
			queries[i] = input.readLine().trim().split(" ");
		}
		input.close();
		solve(queries, t);
    }

}
