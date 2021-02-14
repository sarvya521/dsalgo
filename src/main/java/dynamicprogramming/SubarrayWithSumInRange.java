package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubarrayWithSumInRange {

	static int solve(int arr[], int a, int b) {
		int n = arr.length;
		Set<Integer> set = new HashSet<Integer>();
        int curr_sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
        	curr_sum = curr_sum + arr[i];
        	if (curr_sum >= a && curr_sum <= b) {
        		count++;
            }
        	if(set.contains(curr_sum - b)) {
        		count++;
        	}
        	set.add(curr_sum);
        }
        return count;
    }

	static int solveNew(int arr[], int a, int b) {
		int ans = 0;
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = i; j < n; j++) {
				sum += arr[j];
			}
			if(sum >= a && sum <= b) {
				ans++;
			}
		}
		return ans;
	}
	
	private static void solve(String[] queries) {
		for(int i = 0; i < queries.length; i=i+2) {
			int[] arr1 =  Arrays.stream(queries[i].split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] arr = Arrays.stream(queries[i+1].split(" ")).mapToInt(Integer::parseInt).toArray();
			System.out.println(solve(arr, arr1[1], arr1[2]));
		}
	}
 
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		String[] queries = new String[2*t];
		for(int i = 0; i < t; i= i + 2) {
			queries[i] = input.readLine().trim();
			queries[i+1] = input.readLine().trim();
		}
		input.close();
		solve(queries);
	}
}
