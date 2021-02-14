package ds.stack;

import java.util.Stack;

public class MinStack {

	static enum Operations {
		push, pop, top, getMin
	}
	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer> minStack = new Stack<>();

	static void push(int n) {
		stack.push(n);
		if(minStack.isEmpty()) {
			minStack.push(n);
		} else if(n < minStack.peek()) {
			minStack.push(n);
		}
	}

	static void pop() {
		if(!stack.isEmpty()) {
			final Integer t = stack.pop();
			if(minStack.peek().equals(t)) {
				minStack.pop();
			}
		}
	}

	static int top() {
		return stack.peek();
	}

	static int getMin() {
		if(stack.isEmpty()) {
			return -1;
		}
		return minStack.peek();
	}

	static void operate(String[] arr, int t) {
		String str = null;
		String[] array = null;
		int n;
		for(int i = 0; i < t; i++) {
			str = arr[i];
			array = str.split(" ");
			Operations operation = Operations.valueOf(array[0]);
			switch(operation) {
				case push:
					n = Integer.parseInt(array[1]);
					push(n);
					break;
				case pop:
					pop();
					break;
				case top:
					System.out.print(top()+" ");
					break;
				case getMin:
					System.out.print(getMin()+" ");
					break;
			}
		}
		System.out.println();
	}

	static void operate(String input) {
		String[] arr = input.split(" ");
		for(int i = 0; i < arr.length; i++) {
			if("P".equals(arr[i])) {
				continue;
			}
			switch (arr[i]) {
				case "p":
					pop();
					break;
				case "t":
					System.out.print(top()+" ");
					break;
				case "g":
					System.out.print(getMin()+" ");
					break;
				default:
					push(Integer.parseInt(arr[i]));
					break;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		/*try (BufferedReader input = new BufferedReader (new InputStreamReader(System.in))) {
			int t = Integer.parseInt(input.readLine());
			String[] arr = new String[t];
			for(int i = 0; i < t; i++) {
				arr[i] = input.readLine().trim();
			}
			operate(arr, t);
		}*/
		operate("P 34 g P 35 g P 27 g P 42 g P 5 g P 28 g P 39 g P 20 g P 28 g");
//
//* P  : Corresponds to push() in stack
//* p : Corresponds to pop()
//* t : Corresponds to top()
//* g : Corresponds to getMin() call.
//19 P 10 P 9 g P 8 g P 7 g P 6 g p g p g p g p g p g
	}

}
