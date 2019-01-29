package bitwise;

public class XorSequence {
	
    static void xorSeqOld(long l, long r) {
        long mid = (l + r) / 2;
		long sum1 = 0;
		long sum2 = 0;
		long i, j;
		long index = 1;
        if((mid&1)==1) {
             for(i = l; i < mid; i++) {
                sum1 = sum1 ^ xor(i);
                j = mid + index;
                index++;
                sum2 = sum2 ^ xor(j);
            }
            sum1 = sum1 ^ xor(mid);
            System.out.println(sum1^sum2);
        } else {
            for(i = l; i <= mid; i++) {
                sum1 = sum1 ^ xor(i);
                j = mid + index;
                sum2 = sum2 ^ xor(j);
                index++;
            }
            System.out.println(sum1^sum2);
        }
    }
    
	static void xorSeqNew(long l, long r) {
		long start = System.currentTimeMillis();
		long sum = 0;
		for(long i = l; i <= r; i++) {
			/*rem = i % 4;
			if(rem == 0) {
				sum = sum^i;
			} else if(rem == 1) {
				sum = sum^1;
			} else if(rem == 2) {
				div = i/4;
				sum = sum^(4*div + 3);
			}*/
			sum = sum ^ xor(i);
		}
		System.out.println(sum + " "+(System.currentTimeMillis() - start)+"ms");
	}
	
	static void xorSeq(long l, long r) {
		long start = System.currentTimeMillis();
		long sum = 0;
		long a = l;
		while(a%4 != 0) {
			sum = sum ^ xor(a);
			a++;
		}
		long b = r+1;
		while(b%4 != 0) {
			sum = sum ^ xor(b-1);
			b--;
		}
		if((((b-a)/4)&1) == 1) {
			sum = sum ^ 2;
		}
		System.out.println(sum + " "+(System.currentTimeMillis() - start)+"ms");
	}
	
    static long xor(long a) {
	    long res[] = {a,1,a+1,0};
	    return res[(int) (a%4)];
	}

	static long getXor(long l, long r) {
	     return xor(r) ^ xor(l-1);
	}

	public static void main(String[] args) {
		/*int a = 3^0^4^1^7^0^8^1^11^0^12^1;
		int b = 3^0^4^1^7^0;
		int c = 8^1^11^0^12^1;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(b^c);
		System.out.println();*/
		long l, r;
		l = 6;
		r = 1000000000000000L;
		//xorSeqNew(l, r);
		xorSeq(l, r);
	}

}
