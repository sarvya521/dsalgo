public class TwoSetBits2 {
	
	static long power(long a, long b, int m) {
        long res = 1;     
        while (b != 0) {
			if (b % 2 != 0) {
				res = (res * a) % m;
			}
			a=(a*a)%m;
	        b = b >> 1;
        }
        return res;
    }
    
    static long solve(long n) {
        long r = 0;
        long a = 1;
        while((r=a*(a+1)/2)<n) {
            a++;
        }
        long b = a-(r-n)-1;
        System.out.println(a+"-"+b);
		long n1 = power(2,a,1000000007);
        long n2 = power(2,b,1000000007);
        return (n1 + n2) % 1000000007;
	}
    
    public static void main(String[] args) {
    	System.out.println(solve(100000000000000L));
    }
}
