package string;

import java.util.PriorityQueue;

public class ReverseStringWithoutSpChars {
	
	static void solve(String str) {
		char[] arr = str.toCharArray();
		int n, p1, p2;
		n = str.length();
		p1 = 0;
		p2 = n-1;
		char c1, c2;
		while(p1 < p2) {
			c1 = arr[p1];
			c2 = arr[p2];
			if(Character.isLetter(c1) && Character.isLetter(c2)) {
				arr[p1] = c2;
				arr[p2] = c1;
				p1++;
				p2--;
			} else if(Character.isLetter(c1)) {
				p2--;
			} else if(Character.isLetter(c2)) {
				p1++;
			} else {
				p1++;
				p2--;
			}
		}
		System.out.println(new String(arr));
	}

	public static void main(String[] args) {
		int n = 65;
		System.out.println((char)n);
		n = 90;
		System.out.println((char)n);
		n = 97;
		System.out.println((char)n);
		n = 122;
		System.out.println((char)n);
		System.out.println(Character.isLetter('@'));
		
		solve("s@+=a#rv?e?s*h");
		
		PriorityQueue minHeap=new PriorityQueue();
	}

}
