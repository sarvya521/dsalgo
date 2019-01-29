package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class RectangularAreaHistogram {
	
	static int[] prepareFSR(int[] arr, int n) {
		int[] fsr = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		int e = arr[n-1];
		stack.push(n-1);
		fsr[n-1] = n;
		int top = -1;
		int idx = -1;
		for(int i = n-2; i >= 0; i--) {
			e = arr[i];
			idx = stack.peek();
			top = arr[idx];
			if(top < e) {
				fsr[i] = idx;
			} else {
				while(stack.size() > 0 && arr[stack.peek()] >= e) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					fsr[i] = n;
				} else {
					fsr[i] = stack.peek();
				}
			}
			stack.push(i);
		}
		return fsr;
	}
	
	static int[] prepareFSL(int[] arr, int n) {
		int[] fsl = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		int e = arr[0];
		stack.push(0);
		fsl[0] = -1;
		int top = -1;
		int idx = -1;
		for(int i = 1; i < n; i++) {
			e = arr[i];
			idx = stack.peek();
			top = arr[idx];
			if(top < e) {
				fsl[i] = idx;
			} else {
				while(stack.size() > 0 && arr[stack.peek()] >= e) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					fsl[i] = -1;
				} else {
					fsl[i] = stack.peek();
				}
			}
			stack.push(i);
		}
		return fsl;
	}
	
	static int solve(int[] arr) {
		int n = arr.length;
		int[] fsr = prepareFSR(arr, n);
		int[] fsl = prepareFSL(arr, n);
		int max = n;
		int area = -1;
		for(int i = 0; i < n; i++) {
			area = arr[i] * (fsr[i] - fsl[i] - 1);
			if(area > max) {
				max = area;
			}
		}
		return max;
	}
	
	static void solve(String[] queries, int t) {
		int[] arr = null;
		for(String str : queries) {
			arr = Arrays.asList(str.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
			System.out.println(solve(arr));
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
