package search;

public class CubeRoot {
	
	static long curt(long n) {
		if (n == 0) {
			return 0;
		}
		long x = n;
		long y = 0;
		long z = 0;
		while (y != x && z != x) {
			y = x;
			x = (x + n / x / x) / 2;
			z = x;
			x = (x + n / x / x) / 2;
		}
		return x;
	}
	
	static long diff(long n, long mid, long cube) {
		if (n > (cube))
			return (n - (cube));
		else
			return ((cube) - n);
	}
	
	static long solve(long n) {
		long m = n/3;
		long lo = 0;
		long hi = m;
		
		while(lo <= hi) {
			long mid = (lo+hi)/2;
			long cube = mid*mid*mid;
			long error = diff(n, mid, cube);
			if (error == 0) {
                return mid;
			}
			if(cube > n) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		return 0;
	}
	
	static long solveNew(long n) {
		long ans = 1;
		while(true) {
			n = n / 3;
			ans++;
			if(n < 3) {
				return ans;
			}
		}
	}

	public static void main(String[] args) {
		long cube = 99998L*99998L*99998L;
		//System.out.println(Math.pow(cube, 1/3));
		System.out.println(curt(cube));
	}

}
