package gametheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.geeksforgeeks.org/combinatorial-game-theory-set-2-game-nim/
public class GameOfLetters {

	private static final String S = "Santa";
	private static final String B = "Banta";

	private static String solve(String str) {
		int[] chcnt = new int[26];
		char[] chars = str.toCharArray();
		int n = chars.length;
		for(int i = 0; i < n; i++) {
			chcnt[chars[i]-97] = chcnt[chars[i]-97] + 1;
		}
		int xor = chcnt[0];
		for(int i = 1; i < 26; i++) {
			xor = xor ^ chcnt[i];
		}
		if(xor != 0) {
			return S;
		} else {
			return B;
		}
	}

	public static void main(String[] args) throws Exception {
		StringBuilder builder = new StringBuilder();
		try (BufferedReader input = new BufferedReader (new InputStreamReader(System.in))) {
			int t = Integer.parseInt(input.readLine());
			while(t > 0) {
				builder.append(solve(input.readLine())).append(System.lineSeparator());
				t--;
			}
			System.out.println(builder);
		}
	}
}
