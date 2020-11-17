package algo.bitwise;

import java.util.Scanner;

/*
Given a positive integer, print its binary representation. 

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line containing a single integer. 

Constraints

1 <= T <= 10000 
0 <= N <= 109 

Output Format

For each test case, print binary representation, separated by new line. 

Sample Input 0

5
10
15
7
1
120

Sample Output 0

1010
1111
111
1
1111000
 */
public class BinaryConverter {
	
   /* static String binary(int n) {
		String str = "";
		int div = 0;
		int rem = 0;
		while(n != 1) {
			div = n / 2;
			rem = n % 2;
			n = div;
			str = rem + str;
		}
		str = 1 + str;
		return str;
	}*/
    
    static void binary(int n) {
    	String str = "";
    	while(n != 0) {
    		if((n & 1) == 1) {
    			str = 1 + str;
    		} else {
    			str = 0 + str;
    		}
    		n = n >> 1;
    	}
    	System.out.println(str);
	}
    
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            System.out.println(binary(n));
        }
        in.close();
    }*/

	public static void main(String[] args) {
		binary(15);
	}

}
