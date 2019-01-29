package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CollectingMangoes {
	
	static enum Operations {
		A, Q, R
    }
	
	static final String EMPTY = "Empty";
	
	static List<String[]> queries = new ArrayList<String[]>();
	
	static void push(Stack<Integer> stack, Stack<Integer> biggest, int n) {
		stack.push(n);
		if(biggest.isEmpty() || n >= biggest.peek()) {
			biggest.push(n);
		}
    }
	
	static void peak(Stack<Integer> biggest) {
		if(biggest.isEmpty()) {
			System.out.println(EMPTY);
		} else {
			System.out.println(biggest.peek());
		}
    }
    
    static void pop(Stack<Integer> stack, Stack<Integer> biggest) {
    	if(stack.size() > 0) {
    		int n = stack.pop();
    		if( n == biggest.peek() ) {
    			biggest.pop();
    		}
    	}
    }

	static void solve(int t) {
		String[] arr = null;
		String[] command = null;
		int i, n = 0;
		for( i = 0; i < t; i++) {
			arr = queries.get(i);
			System.out.println("Case "+(i+1)+":");
			Stack<Integer> stack = new Stack<Integer>();
			Stack<Integer> biggest = new Stack<Integer>();
			for(String s : arr) {
				command = s.split(" ");
				Operations operation = Operations.valueOf(command[0]);
				switch(operation) {
					case A:
						n = Integer.parseInt(command[1]);
						push(stack, biggest, n);
						break;
					case Q:
						peak(biggest);
						break;
					case R:
						pop(stack, biggest);
						break;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		int i, j, n;
		for(i = 0; i < t; i++) {
			n = Integer.parseInt(input.readLine());
			String[] arr = new String[n];
			for(j = 0; j < n; j++) {
				arr[j] = input.readLine().trim();
			}
			queries.add(arr);
		}
		input.close();
		solve(t);
	}
}
