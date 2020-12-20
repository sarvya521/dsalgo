package algo.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CompressString {

	private static void solve(String str) {
		final char[] chars = str.toCharArray();
		int n = chars.length;
		int count = 1;
		char currentChar = chars[0];
		for(int i = 1; i < n; i++) {
			if(chars[i] == currentChar) {
				count ++;
			} else {
				System.out.print(currentChar+""+count);
				currentChar = chars[i];
				count = 1;
			}
		}
		System.out.print(currentChar+""+count);
	}

	public static void main(String[] args) throws Exception {
		String input = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			input = br.readLine();
		}
		solve(input);
	}

}
