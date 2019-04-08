package algo.bitwise;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CounterGamePowerTwo {
	
	static String counterGameNew(long n) {
        boolean Richard = true; 
		while(n > 1) {
			long k = n;
			if((n & (n - 1)) == 0) {
				String str = Long.toBinaryString(n);
				int length = str.length() - 1;
				if(Richard) {
                    if((length&1)==1) {
					   return "Louise";
                    } else {
                        return "Richard";
                    }                    
                } else {
                    if((length&1)==1) {
						return "Richard";
                    } else {
                        return "Louise";
                    }
                }
			} else {
				k--;
				while((k & (k - 1)) != 0) {
					k--;
				}
				n = n - k;
			}
			Richard = !Richard;
		}
		
		return Richard ? "Richard" : "Louise";
    }
	
	static String binary(long n) {
		String finalstr = "0000000000000000000000000000000000000000000000000000000000000000";
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
	
	static long highestBit(long n) {
		String binary = binary(n);
		int highestSetBitIndex = -1;
		for(int i = binary.length() - 1; i >= 0; i--) {
			if(binary.charAt(i) == '1') {
				highestSetBitIndex += 1;
			}
		}
		return 1<<highestSetBitIndex;
	}


	static String counterGame(long n) {
		boolean Richard = true; 
		if(n == 1) {
			return "Richard";
		}
		while(n > 1) {
			//long k = n;
			if((n & (n - 1)) == 0) {
				n = n / 2;
			} else {
				/*k--;
				while((k & (k - 1)) != 0) {
					k--;
				}
				n = n - k;*/
				//n = n - Long.highestOneBit(n);
				n = n - highestBit(n);
			}
			Richard = !Richard;
		}
		
		return Richard ? "Richard" : "Louise";
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            String result = counterGame(n);
            System.out.println(result);
        }
        in.close();*/
    	
    	//9223372036854775808
    	//4611686018427387904
    	
    	/*for(int i = 1; i <= 16; i++) {
    		System.out.println(binary(i));
    	}
    	
    	System.out.println(highestBit(15));
    	
    	
    	System.exit(1);
    	
    	long i = (1L<<8);
    	i |= (i >>  1);
        i |= (i >>  2);
        i |= (i >>  4);
        i |= (i >>  8);
        i |= (i >> 16);
        i |= (i >> 32);
        System.out.println(i);
        i = i - (i >>> 1);
        System.out.println(i);
        System.out.println(1L<<8);
    	
    	System.out.println(Long.highestOneBit(1L<<8));
    	
    	System.out.println(binary(312312321311212L));*/
        
    	long n = 15;
        String result = counterGameNew(n);
        System.out.println(result);
        
        result = counterGame(n);
        System.out.println(result);
    }

}
