package algo.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConvertingAnagrams {
	
	private static int solve(String str1, String str2) {
		int count1[] = new int[26];
		int count2[] = new int[26];

		for (int i = 0; i < str1.length(); i++) {
			count1[str1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < str2.length(); i++) {
			count2[str2.charAt(i) - 'a']++;
		}

		int result = 0;
		for (int i = 0; i < 26; i++) {
			result += Math.abs(count1[i] - count2[i]);
		}
		return result;
	}
	
	private static void solve(String[] queries) {
		String[] arr = null;
		for(String query : queries) {
			arr = query.split(" ");
			System.out.println(solve(arr[0], arr[1]));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		String[] queries = new String[t];
		for(int i = 0; i < t; i++) {
			queries[i] = input.readLine().trim();
		}
		input.close();
		solve(queries);
	}
}
