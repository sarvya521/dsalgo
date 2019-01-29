package deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Deque {

	static enum Operations {
        push_back, push_front, pop_back, pop_front
    }
    
    static List<Integer> deque = new LinkedList<Integer>();
    static int front = 0;
    static int rear = -1;
    
    static void pushBack(int n) {
    	rear++;
    	deque.add(rear, n);
    }
    
    static void pushFront(int n) {
    	rear++;
    	deque.add(0, n);
    }
    
    static void popBack() {
    	if(deque.isEmpty()) {
    		System.out.println("Empty");
    		return;
    	} 
    	int n = deque.remove(rear);
    	System.out.println(n);
    	rear--;
    }
    
    static void popFront() {
    	if(deque.isEmpty()) {
    		System.out.println("Empty");
    		return;
    	} 
    	int n = deque.remove(front);
    	System.out.println(n);
    	rear--;
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
				case push_back:
					n = Integer.parseInt(array[1]);
					pushBack(n);
					break;
				case push_front:
					n = Integer.parseInt(array[1]);
					pushFront(n);
					break;
				case pop_back:
					popBack();
					break;
				case pop_front:
					popFront();
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
