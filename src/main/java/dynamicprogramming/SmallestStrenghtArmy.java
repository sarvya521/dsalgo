package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class SmallestStrenghtArmy {
	
	private static int solve(int[] arr) {
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		int n = arr.length;
		Stack<Integer> stack = new Stack<Integer>();
		if(arr[0] != 1) {
			return 1;
		}
		stack.push(arr[0]);
		for(int i = 1; i < n; i++) {
			if(arr[i] == stack.peek()+1) {
				int m = stack.peek()+1;
				stack.push(arr[i]);
				stack.push(m);
			} else if(arr[i] + arr[i-1] == stack.peek()+1) {
				stack.push(arr[i] + arr[i-1]);
			} else {
				return stack.peek()+1;
			}
		}
		return 0;
	}

	private static void solve(String[] queries) {
		int[] arr = null;
		for(String query : queries) {
			arr = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			System.out.println(solve(arr));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		String[] queries = new String[t];
		for(int i = 0; i < t; i++) {
			Integer.parseInt(input.readLine());
			queries[i] = input.readLine().trim();
		}
		input.close();
		solve(queries);
	}

}
