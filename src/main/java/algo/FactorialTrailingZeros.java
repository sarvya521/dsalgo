package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FactorialTrailingZeros {
	
	static long solve(long n) {
		long count = 0;
        for (long i=5; n/i>=1; i *= 5) {
            count += n/i;
        }
        return count;
    }
	
	static long fact(long n) {
		long i, fact = 1;
		for (i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}

	public static void main(String[] args) throws Exception {
		/*for(int i = 5; i < 21; i++) {
			System.out.println(i+"\t"+fact(i)+"\t"+solve(i));
		}*/

		System.out.println(fact(100));

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
