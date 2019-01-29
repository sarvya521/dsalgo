package algo.bitwise;

public class ReverseBits {
	
	static long solve(int n) {
		int index = 31;
		long ans = 0;
		while(n != 0) {
			if((n & 1) == 1) {
				ans += 1<<index;
			}
			index--;
			n = n >> 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solve(15));
		System.out.println((1<<31) + (1<<30) + (1<<29) + (1<<28));
		System.out.println(Long.toBinaryString(4026531840l));
	}

}
