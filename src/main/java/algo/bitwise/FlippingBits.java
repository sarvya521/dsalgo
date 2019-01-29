package algo.bitwise;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FlippingBits {
	
	static String binary(long n) {
		String finalstr = "00000000000000000000000000000000";
		if(n == 0) {
			return finalstr;
		}
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
		return finalstr.substring(0, finalstr.length() - str.length())+str;
	}

	static long flippingBits(long N) {
		long start = System.currentTimeMillis();
		String binary = binary(N);
		long n = 0;
		int j = 0;
		for(int i = binary.length() - 1; i >= 0 ; i--, j++) {
			if(binary.charAt(i) == '0') {
				n += 1L<<j;
			}
		}
		System.out.println(System.currentTimeMillis() - start +"ms");
		return n;
    }
	
	static long flippingBitsNew(long N) {
		long start = System.currentTimeMillis();
		long ans = 0;
		int index = 0;
		while(index < 32) {
			if((N & 1) == 0) {
				ans += 1L<<index;
			}
			N = N >> 1;
			index++;
		}
		System.out.println(System.currentTimeMillis() - start +"ms");
		return ans;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            long N = in.nextLong();
            long result = flippingBits(N);
            System.out.println(result);
        }
        in.close();*/
        
        long result = flippingBits(0);
        System.out.println(result);
        
        result = flippingBitsNew(0);
        System.out.println(result);
    }
}
