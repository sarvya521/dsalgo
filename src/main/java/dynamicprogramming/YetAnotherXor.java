package dynamicprogramming;

public class YetAnotherXor {

	static void partSubequenceSum(int[] input, int n) {
		for(int i = 0; i<(1<<n); i++) {
			for(int j = 0; j < n; j++) {
				if((i & (1<<j)) > 0) {
					System.out.print(input[j]+" ");
				}
			}
			System.out.println("\n");
		}
	}
	public static void main(String[] args) {
		partSubequenceSum(new int[]{3, 2, 1, 0}, 4);
	}
}
