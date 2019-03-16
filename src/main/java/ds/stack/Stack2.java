package ds.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Stack2 {

	static enum Operations {
		push, pop
    }
    
    static Deque<Integer> stack = new ArrayDeque<Integer>();
    static int top = -1;
    
    static void push(int n) {
    	top++;
    	stack.push(n);
    }
    
    static void pop() {
    	if(stack.isEmpty()) {
    		System.out.println("Empty");
    		return;
    	} 
    	int n = stack.pop();
    	System.out.println(n);
    	top--;
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
			}
		}
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		String[] arr = new String[t];
		for(int i = 0; i < t; i++) {
			arr[i] = input.readLine().trim();
		}
		input.close();
		operate(arr, t);
    }

}
