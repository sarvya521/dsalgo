package algo.matrix;

import java.util.HashMap;
import java.util.Map;

public class FactorialTrailingZeros {
	
	static long solve(long n) {
        long count = 0;
        for (long i=5; n/i>=1; i *= 5) {
            count += n/i;
        }
        return count;
    }
	
	static long fact(long n) {
		long i, fact = 1;
		for (i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}

	public static void main(String[] args) {
		/*long i, fact = 1;
		long number = 7;//(long)Math.pow(10, 15);
		for (i = 1; i <= number; i++) {
			fact = fact * i;
		}
		int count = 0;
		while(fact > 119) {
			if(fact % 10 == 0) {
				count++;
			}
			fact = fact/10;
		}
		System.out.println("Factorial Zero Count of " + number + " is: "+count);*/
		for(int i = 5; i < 21; i++) {
			System.out.println(i+"\t\t\t"+fact(i)+"\t\t\t"+solve(i));
		}
		
	}

}
