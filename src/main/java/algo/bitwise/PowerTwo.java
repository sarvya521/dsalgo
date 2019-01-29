package algo.bitwise;

public class PowerTwo {
	
	static boolean check(long n) {
		if((n & (n-1)) == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(check(0));
		System.out.println(check(16));
	}

}
