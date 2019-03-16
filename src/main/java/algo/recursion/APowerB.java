package algo.recursion;

import java.util.Scanner;

public class APowerB {
	
	static long power(int a, int b) {
		long x = 1, y = a;
		while (b > 0) {
			if (b % 2 == 1) {
				x = (x * y) % 1000000007;
			}
			y = (y * y) % 1000000007;
			b /= 2;
		}
		return x % 1000000007;
	}
	
	static long powerRec(int a, int b) {
		if (b == 0) {
			return 1;
		}
		long temp = powerRec(a, b / 2);
		temp = (temp * temp) % 1000000007;
		if (b % 2 == 0) {
			return temp;
		} else {
			return (a * temp) % 1000000007;
		}
	}
	
	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(power(a, b));
        }
        in.close();*/
		System.out.println(powerRec(99999, 999));
		System.out.println(power(99999, 999));
	}

}
