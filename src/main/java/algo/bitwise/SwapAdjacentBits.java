package algo.bitwise;

public class SwapAdjacentBits {
	
	static long solve(int n) {
		return ((n & 715827882) >> 1) | ((n & 1431655765) << 1);
	}

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("101010101010101010101010101010", 2));
		System.out.println(Integer.parseInt("01010101010101010101010101010101", 2));
		System.out.println(solve(10));
		System.out.println(solve(7));
		System.out.println(solve(43));
		System.out.println(solve(100));
	}

}
