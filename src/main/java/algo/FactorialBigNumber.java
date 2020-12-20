package algo;

public class FactorialBigNumber {

	static final int MOD = (int)1e9 + 7;

	static long solve(int n) {
		long result = 1;
		for (int i = 1; i <= n; i++)
			result = (result * i) % MOD;
		return result;
	}

	/*public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			for(int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				System.out.println(solve(n));
			}
		}
	}*/

	// This function finds factorial of
	// large numbers and prints them
	static void factorial(int n)
	{
		int res[] = new int[500];

		// Initialize result
		res[0] = 1;
		int res_size = 1;

		// Apply simple factorial formula
		// n! = 1 * 2 * 3 * 4...*n
		for (int x = 2; x <= n; x++)
			res_size = multiply(x, res, res_size);

		for (int i = res_size - 1; i >= 0; i--)
			System.out.print(res[i]);
	}

	// This function multiplies x with the number
	// represented by res[]. res_size is size of res[] or
	// number of digits in the number represented by res[].
	// This function uses simple school mathematics for
	// multiplication. This function may value of res_size
	// and returns the new value of res_size
	static int multiply(int x, int res[], int res_size)
	{
		int carry = 0; // Initialize carry

		// One by one multiply n with individual
		// digits of res[]
		for (int i = 0; i < res_size; i++)
		{
			int prod = res[i] * x + carry;
			res[i] = prod % 10; // Store last digit of
			// 'prod' in res[]
			carry = prod/10; // Put rest in carry
		}

		// Put carry in res and increase result size
		while (carry!=0)
		{
			res[res_size] = carry % 10;
			carry = carry / 10;
			res_size++;
		}
		return res_size;
	}

	public static void main(String[] args) throws Exception {
		/*for(int i = 5; i < 21; i++) {
			System.out.println(i+"\t"+fact(i)+"\t"+solve(i));
		}*/

		factorial(1);
		System.out.println();
		factorial(100);

		/*List<String> lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				lines.add(br.readLine());
				t--;
			}
		}
		lines.forEach(line -> {
			System.out.println(solve(Long.parseLong(line)));
		});*/
	}

}
