package algo.bitwise;

public class FlipBitsAtoB {

	static int solve(int a, int b) {
		int n = a^b;
		int count  = 0;
		while(n != 0) {
			if((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(solve(1, 153));
	}

}
