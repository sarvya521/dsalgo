package ds.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Stack {

	static enum Operations {
		push, pop, top, getMin
	}
	static int maxsize = (int)1e8;
	static int[] arr = new int[maxsize];
	static int[] minarr = new int[maxsize];
	static int top = -1;

	static int size() {
		return top+1;
	}

	static void push(int n) {
		int prevmin;
		if(top == -1) {
			prevmin = Integer.MAX_VALUE;
		} else {
			prevmin = minarr[top];
		}
		top++;
		arr[top] = n;
		if(n < prevmin) {
			minarr[top] = n;
		} else {
			minarr[top] = prevmin;
		}
	}

	static void pop() {
		if(size() == 0) {
			//System.out.println("Empty");
			return;
		}
		//System.out.println(arr[top]);
		top--;
	}

	static int top() {
		return top;
	}

	static int getMin() {
		if(top == -1) {
			return -1;
		}
		return minarr[top];
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
		operate("P 10 P 9 g P 8 g P 7 g P 6 g p g p g p g p g p g");
//
//* P  : Corresponds to push() in stack
//* p : Corresponds to pop()
//* t : Corresponds to top()
//* g : Corresponds to getMin() call.
//19 P 10 P 9 g P 8 g P 7 g P 6 g p g p g p g p g p g
	}

}
