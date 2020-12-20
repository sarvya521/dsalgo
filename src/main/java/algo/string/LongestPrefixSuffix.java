package algo.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestPrefixSuffix {

	private static void solve(String str) {
		final char[] chars = str.toCharArray();
		int n = chars.length;
		int ans = 0;

		if(n < 2) {
			System.out.println(ans);
			return;
		}

		int i = 0;
		for(int j = 1; j < n && i < n; j++) {
			if(chars[i] == chars[j]) {
				ans++;
				i++;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		String input = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			input = br.readLine();
		}
		solve(input);
	}

}
