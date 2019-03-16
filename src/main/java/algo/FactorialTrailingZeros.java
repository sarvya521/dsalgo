package algo;

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
		for(int i = 5; i < 21; i++) {
			System.out.println(i+"\t"+fact(i)+"\t"+solve(i));
		}
	}

}
