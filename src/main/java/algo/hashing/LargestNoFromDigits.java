package algo.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class LargestNoFromDigits {

    static void solve(int n) {
	int[] arr = new int[10];
	int r;
	while (n != 0) {
	    r = n % 10;
	    arr[r] = arr[r] + 1;
	    n = n / 10;
	}
	StringBuilder builder = new StringBuilder();
	int cnt;
	for (int i = 9; i >= 0; i--) {
	    cnt = arr[i];
	    while (cnt != 0) {
		builder.append(i);
		cnt--;
	    }
	}
	System.out.println(builder);
    }

    static void solve(int[] queries) {
	System.out.println(Arrays.stream(queries).mapToObj(String::valueOf).sorted(Comparator.reverseOrder())
		.map(e -> e.toString()).reduce("", String::concat));
    }

    static void solve(String[] queries, int n) {
	Arrays.sort(queries);
	for (int i = n - 1; i >= 0; i--) {
	    System.out.print(queries[i]);
	}
    }

    public static void main(String[] args) throws Exception {
	/*
	 * BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
	 * int t = Integer.parseInt(input.readLine()); int i; String[] queries = new
	 * String[t]; for(i = 0; i < t; i++) { input.readLine(); queries[i] =
	 * input.readLine().trim(); } input.close();
	 */
	solve(38293367);
	solve(new int[] { 54, 548, 546, 60 });
    }

}
