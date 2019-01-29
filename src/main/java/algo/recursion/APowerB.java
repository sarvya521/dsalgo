package algo.recursion;

import java.util.Scanner;

public class APowerB {
	
	static long modulo(int a,int b,int n){
	    long x=1,y=a; 
	    while(b > 0){
	        if(b%2 == 1){
	            x=(x*y)%n;
	        }
	        y = (y*y)%n;
	        b /= 2;
	    }
	    return x%n;
	}
	
	static long power(int a, int b) {
	    if(b == 0) {
	        return 1;
	    }
	    long temp = power(a, b/2);
	    temp = (temp * temp) % 1000000007;
	    if (b%2 == 0) { 
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
		System.out.println(Math.pow(99999, 999));
		System.out.println((Math.pow(99999, 999))%1000000007);
		System.out.println(power(99999, 999));
		System.out.println(modulo(99999, 999, 1000000007));
	}

}
