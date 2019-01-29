import java.math.BigDecimal;
import java.math.BigInteger;

public class TwoSetBits {
	
	static long nextCounter(long n) {
		long counter = 0;
		long num = 0;
		while(num <= n) {
			counter++;
			num = (counter*(counter-1)/2) + 1;
		}
		return counter;
	}
	
	static long getNum(long n) {
		long counter = nextCounter(n);
		long num = (counter*(counter-1)/2) + 1;
		long firstIndex = counter - 1;
		long secondIndex = firstIndex - (num - n);
		long n1 = powerNew(2,firstIndex,1000000007);
        long n2 = powerNew(2,secondIndex,1000000007);
        return (n1 + n2) % 1000000007L;
		//System.out.println(ans%1000000007);
		//System.out.println(((n1%1000000007) + (n2%1000000007))%1000000007);
	}
	
    /*static long solve(long n) {
		long counter = 0;
		long num = 0;
		while(num <= n) {
			counter++;
			num = (counter*(counter-1)/2) + 1;
		}
		long firstIndex = counter - 1;
		long secondIndex = firstIndex - (num - n);
		
		long n2 = power(2,secondIndex,1000000007);
        
        long n3 = power(2,(firstIndex-secondIndex),1000000007);
        
        long n1 = (n2 * n3) % 1000000007;
        
		long ans = (n1 + n2) % 1000000007;
		return ans;
	}*/
	
	/*static long solve(long n) {
		long counter = 0;
		long num = 0;
		while(num <= n) {
			counter++;
			num = (counter*(counter-1)/2) + 1;
		}
		
		long firstIndex = counter - 1;
		long secondIndex = firstIndex - (num - n);
		long n1 = (1L<<(firstIndex));
		long n2 = (1L<<(secondIndex));
		long ans = ((n1%1000000007) + (n2%1000000007))%1000000007;
		return ans;
	}*/
	
	/*static void solve(int n) {
		int i = 1;
		int counter = 1;
		while(i < n) {
			i = i + counter;
			counter++;
		}
		//System.out.println("counter="+counter);
		//System.out.println(i);
		//System.out.println(i-counter+1);
		
		if(i == n) {
			System.out.println((1<<(counter)) + 1);
			return;
		}
		
		int start = i-counter+1;
		int num = (1<<(counter-1)) + 1;
		int index = 0;
		while(start < n) {
			num += 1<<index;
			index++;
			start++;
		}
		System.out.println(num);
	}*/
	
	/*static long power(long a, long b, int m) {
        long res = 1;     
        a = a % m; 
     
        while (b > 0) {
            if((b & 1)==1) {
                res = (res * a) % m;
            }
            b = b >> 1; 
            a = (a * a) % m; 
        }
        return res;
    }

    static long solve(long n) {
		long counter = 0;
		long num = 0;
		while(num <= n) {
			counter++;
			num = (counter*(counter-1)/2) + 1;
		}
		long firstIndex = counter - 1;
		long secondIndex = firstIndex - (num - n);
		
		long n2 = power(2,secondIndex,1000000007);
        
        long n3 = power(2,(firstIndex-secondIndex),1000000007);
        
        long n1 = (( n2 % 1000000007 ) * ( n3 % 1000000007)) % 1000000007;
        
        long ans = (( n1 % 1000000007 ) + ( n2 % 1000000007)) % 1000000007;
		return ans;
	}*/

	public static void main(String[] args) {
		/*for(int i = 1; i <= 16; i++) {
			solve(i);
		}*/
		//System.out.println(solve(1000000000000000L));
		/*long start = System.currentTimeMillis();
		System.out.println(power(2, 10000000000000L, 1000000007) +" - "+(System.currentTimeMillis() - start)+"ms");
		start = System.currentTimeMillis();
		System.out.println(power2mod(10000000000000L, 1000000007) +" - "+(System.currentTimeMillis() - start)+"ms");*/
		/*for(int i = 1; i <= 100; i++) {
			System.out.println(solve(i) +" - "+ GetTwoBitSequenceValue(i));
		}*/
		//System.out.println(solve(100000000000000L) + "-" + getTwoBitSequenceValue(100000000000000L, 1000000007));
		/*System.out.println(Integer.toBinaryString(2000000013));
		System.out.println(Integer.toBinaryString(16));
		System.out.println(2000000013 | 16);
		System.out.println((2000000013 | 16)%1000000007);
		System.out.println("----------------------------------");
		System.out.println(((2000000013%1000000007) | (16%1000000007))%1000000007);*/
		/*long start = System.currentTimeMillis();
		System.out.println(solve(100000000000000L) +"-"+ (System.currentTimeMillis() - start)+"ms"); //242337942
		System.out.println(getTwoBitSequenceValue(100000000000000L)); //665723720
		start = System.currentTimeMillis();
		System.out.println(test(100000000000000L) +"-"+ (System.currentTimeMillis() - start)+"ms"); //291172003
*/		
		//System.out.println(getNum(100000000000000L));
		System.out.println(getTwoBitSequenceValue(100000000000000L)); //242337942
		//System.out.println(test(100000000000000L));
	}
	
	public static long getTwoBitSequenceValue(long n) {
		long a = (long)Math.floor((1 + Math.sqrt(1 + 8 * n - 8)) / 2);
	    long b = (n - (a * (a - 1) / 2) - 1);

	    //System.out.println(a+"-"+b);
	    //return BigInteger.ZERO.setBit(a).add(BigInteger.ZERO.setBit(b)).mod(new BigInteger("1000000007")).longValue();
	    long n1 = powerNew(2,a,1000000007);
        long n2 = powerNew(2,b,1000000007);
        return (n1 + n2) % 1000000007L;
	}
	
	public static long test(long n) {
        long r = 0;
        long i = 1;
        while((r=i*(i+1)/2)<n) {
            i++;
        }
        //System.out.println("f(" + n + ") = " +(long)(Math.pow(2, i) + Math.pow(2, i-(r-n)-1)));
        
        long n1 = powerNew(2,i,1000000007);
        
        long n2 = powerNew(2,(i-(r-n)-1),1000000007);
        
        return (n1 + n2) % 1000000007L;
    }
	
    static long solve(long n) {
		long counter = 0;
		long num = 0;
		while(num <= n) {
			counter++;
			num = (counter*(counter-1)/2) + 1;
		}
		long firstIndex = counter - 1;
		long secondIndex = firstIndex - (num - n);
		
		long n2 = power(2,secondIndex,1000000007);
        
        long n3 = power(2,(firstIndex-secondIndex),1000000007);
        
        //long n1 = (n2 * n3) % 1000000007;
        long n1 = (( n2 % 1000000007 ) * ( n3 % 1000000007)) % 1000000007;
        
		//long ans = (n1 + n2) % 1000000007;
        long ans = (( n1 % 1000000007 ) + ( n2 % 1000000007)) % 1000000007;
		return ans;
	}
    
    static long power(long a, long b, int m) {
        long res = 1;     
        a = a % m; 
     
        while (b > 0) {
            if((b & 1)==1) {
                res = (res * a) % m;
            }
            b = b >> 1; 
            a = (a * a) % m; 
        }
        return res;
    }
    
    static long powerNew(long a, long b, int m) {
        long res = 1;     
        while (b > 0) {
			if (b % 2 == 1) {
				res = (res * a) % m;
			}
			a=(a*a)%m;
	        b = b >> 1;
        }
        return res;
    }
    
    /*static long power2mod(long pow, long mod) {
	long a = 2;
	long result = 1;
	while(pow > 0) {
		if((pow & 1) == 1) {
			a = a % mod;
			result = (result * a) % mod;
			result = result % mod;
		}
		pow = pow >> 1;
		a = a % mod;
		a = (a * a) % mod;
		a = a % mod;
	}
	return result;
	}*/
	
	/*static long solve(long n) {
		long ans = 0;
		for (long i = 1; 1L << i < n; i++) {
			for (long j = 0; j < i; j++) {
				long num = (1L << i) + (1L << j);
				if(num > n) {
					break;
				}
				ans = num;
				//System.out.println(ans);
			}
		}
		return ans % 1000000007L;
	}*/
	
	/*static float squareRoot(long n) {
		long x = n;
		long y = 1;
		double e = 0.44d;
		while (x - y > e) {
			x = (x + y) / 2;
			y = n / x;
		}
		return x;
	}*/
	
	/*static long power(long a, long b)
    {
        long ans = 1;     
        
        while (b > 0) {
            if((b & 1)==1)
                ans = ans * a;
            b = b >> 1; 
            a = a * a; 
        }
        return ans;
    }*/

}
