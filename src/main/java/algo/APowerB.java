package algo;

import java.util.Scanner;

/*
Given 2 numbers - a and b, evaluate ab. 

Input Format

First line of input contains T - number of test cases. 
Its followed by T lines, each line containing 2 numbers - a and b, separated by space. 

Constraints

30 points 
1 <= T <= 1000 
0 <= a <= 106 
0 <= b <= 103 

70 points 
1 <= T <= 1000 
0 <= a <= 106 
0 <= b <= 109 

Output Format

For each test case, print ab, separated by new line. 
Since the result can be very large, print result % 1000000007 

Sample Input 0

4
5 2
1 10
2 30
10 10

Sample Output 0

25
1
73741817
999999937
 */
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

	private static void powerSimple(int a, int b) {
		long p = 1;
		while(b > 0) {
			p = p * a;
			b--;
		}
		System.out.println(p);
	}

	private static long powerSimpleRec(long a, long b) {
		if(b == 1) {
			return a;
		}
		a = powerSimpleRec(a, b-1) * a;
		return a;
	}

//	public static void main(String[] args) throws Exception {
//		String input = null;
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//			input = br.readLine();
//		}
//		String[] ip = input.split(" ");
//		power(Integer.parseInt(ip[0]), Integer.parseInt(ip[1]));
//	}
	
	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(power(a, b));
        }
        in.close();*/
		/*System.out.println(powerRec(99999, 999));
		System.out.println(power(99999, 999));*/
		System.out.println(Math.pow(9, 6));

		System.out.println(powerSimpleRec(9, 6));
	}

}
