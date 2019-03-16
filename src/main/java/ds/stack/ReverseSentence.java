package ds.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseSentence {
	
	static void reverse(String str) {
		String[] arr = str.split(" ");
		if(arr.length == 1) {
			System.out.println(str);
			return;
		}
		Stack<String> stack = new Stack<String>();
		for(String s: arr) {
			stack.push(s);
		}
		StringBuilder builder = new StringBuilder("");
		for(String s: arr) {
			builder.append(stack.pop()).append(" ");
		}
		System.out.println(builder);
	}

	static void reverse(String[] arr, int t) {
		String str = null;
		for(int i = 0; i < t; i++) {
			str = arr[i];
			reverse(str);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		String[] arr = new String[t];
		for(int i = 0; i < t; i++) {
			arr[i] = input.readLine().trim();
		}
		input.close();
		reverse(arr, t);
	}

}
