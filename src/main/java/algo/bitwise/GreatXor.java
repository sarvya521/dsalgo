package algo.bitwise;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GreatXor {
	
	static String binary(long n) {
		String str = "";
		long div = 0;
		long rem = 0;
		while(n != 1) {
			div = n / 2;
			rem = n % 2;
			n = div;
			str = rem + str;
		}
		str = 1 + str;
		return str;
	}
	
	static long flip(String str) {
		long n = 0;
		int j = 0;
		for(int i = str.length() - 1; i >= 0 ; i--, j++) {
			if(str.charAt(i) == '0') {
				n += 1L<<j;
			}
		}
		return n;
	}
	
	static void theGreatXor() {
		for(long n = 2; n < 64; n++) {
			System.out.println(n+" - "+Long.toBinaryString(n)+" - "+flip(binary(n)));
		}
	}
	
	/*static void theGreatXor(long n) {
		System.out.println(n+" - "+Long.toBinaryString(n)+" - "+flip(binary(n)));
	}*/

	static void solve() {
		for(long n = 1; n < 64; n++) {
			int count = 0;
			long i = 1;
			while(i < n) {
				if((n ^ i) > n) {
					count++;
				}
				i++;
			}
			System.out.println(n+" - "+Long.toBinaryString(n)+" - "+count);
		}
    }
	
    static long theGreatXor(long x){
        if(x == 0 || x == 1) {
            return 0;
        }
        return flip(binary(x));
    }
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/home/sarvesh/Downloads/input07.txt");
        Scanner in = new Scanner(file);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long result = theGreatXor(x);
            System.out.println(result);
        }
        in.close();
    }

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = solve(n);
        long result = theGreatXor(1000000000000000L);
        System.out.println(result);
        solve();
        System.out.println("===============================");
    	theGreatXor(3548685978l);
    	String str = Long.toBinaryString(3548685978l);
		int j = 0;
		String flip = "";
		for(int i = 0; i < str.length() ; i++) {
			if(str.charAt(i) == '0') {
				flip += "1";
			} else {
				flip += "0";
			}
		}
		System.out.println(flip);
		System.out.println(Long.parseLong(flip, 2));
		//10011100010000
    }*/
	
	

}
