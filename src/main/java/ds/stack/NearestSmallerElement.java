package ds.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

	private static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> minStack = new Stack<>();
		stack.push(-1);
		minStack.push(A.get(0));
		for(int i = 1; i < A.size(); i++) {
			Integer e = A.get(i);
			final Integer top = stack.peek();
			if(e <= top && e <= A.get(i-1)) {
				while(!minStack.isEmpty() && minStack.peek() > e) {
					minStack.pop();
				}
				if(minStack.isEmpty()) {
					stack.push(-1);
				} else {
					stack.push(minStack.peek());
				}
			} else if(e > top && e > A.get(i-1)) {
				stack.push(Math.max(top, A.get(i - 1)));
			} else if(e > A.get(i-1)) {
				stack.push(A.get(i-1));
			} else if(e > top) {
				stack.push(top);
			} else {
				stack.push(-1);
			}
			if(minStack.isEmpty() || e < minStack.peek()) {
				minStack.push(e);
			}
		}
		return new ArrayList<>(stack);
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
//		System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8))));
//		System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(34, 35, 27, 42, 5, 28, 39, 20, 28))));
//		//-1 34 -1 27 -1 5 28 5 20
//		System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8))));
//		System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(4, 3, 2, 1))));
//		System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(48, 38, 42, 39, 28, 6, 49, 34))));
//		System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(8, 23, 22, 16, 22, 7, 7, 27, 35, 27, 32, 20, 5, 1, 35, 28, 20, 6, 16, 26, 48, 34))));
		//-1 8 8 8 16 -1 -1 7 27 7 27 7 -1 -1 1 1 1 1 6 16 26 26
		System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(7, 16, 23, 47, 26, 9, 35, 35, 9, 34, 6, 41, 29, 1, 17, 14, 8, 2, 33, 25, 20, 50, 43, 11, 47, 25, 45))));
		//-1 7 16 23 23 7 9 9 7 9 -1 6 6 -1 1 1 1 1 2 2 2 20 20 2 11 11 25

	}

}
