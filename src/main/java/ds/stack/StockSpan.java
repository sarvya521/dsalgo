package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
	
	static void solve(int[] arr) {
		int n = arr.length;
		int[] s = new int[n];
		s[0] = 1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		for (int i = 1; i < n; i++) {
			while (!stack.empty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			s[i] = (stack.empty()) ? (i + 1) : (i - stack.peek());
			stack.push(i);
		}
		StringBuilder builder = new StringBuilder("");
		for(int i : s) {
			builder.append(i).append(" ");
		}
		System.out.println(builder);
	}
	
	static void solve(String[] queries, int t) {
		int[] arr = null;
		for(String str : queries) {
			arr = Arrays.asList(str.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
			solve(arr);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		int i;
		String[] queries = new String[t];
		for(i = 0; i < t; i++) {
			input.readLine();
			queries[i] = input.readLine().trim();
		}
		input.close();
		solve(queries, t);
	}
}
