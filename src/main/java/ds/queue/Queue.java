package ds.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Queue {

	static enum Operations {
		Enqueue, Dequeue
    }
    
    static List<Integer> queue = new LinkedList<Integer>();
    static int front = 0;
    static int rear = -1;
    
    static void enqueue(int n) {
    	rear++;
    	queue.add(rear, n);
    }
    
    static void dequeue() {
    	if(queue.isEmpty()) {
    		System.out.println("Empty");
    		return;
    	} 
    	int n = queue.remove(front);
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
				case Enqueue:
					n = Integer.parseInt(array[1]);
					enqueue(n);
					break;
				case Dequeue:
					dequeue();
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
