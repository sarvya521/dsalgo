package matrix;

import java.util.Scanner;

public class ArraySum {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int size = in.nextInt();
			long sum = 0;
			for(int j = 0; j < size; j++) {
				sum += in.nextLong(); 
			}
			System.out.println(sum);
		}
		in.close();
	}
}
