package algo.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OnlyVowelsString {

	private static void solve(String str) {
		final char[] chars = str.toLowerCase().toCharArray();
		int n = chars.length;
		boolean flag = false;
		for(int i = 0; i < n; i++) {
			if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u' || chars[i] == 'y') {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		System.out.println(flag ? "Yes" : "No");
	}

	public static void main(String[] args) throws Exception {
		String input = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			input = br.readLine();
		}
		solve(input);
	}

}
