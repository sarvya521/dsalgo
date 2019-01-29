package dynamicprogramming;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class WordsVowelsConsonants {
	
	static final List<Character> VOWELS = new ArrayList<Character>(); 
	
	static void solve(String[] arr, int n) {
		String s;
		int i, j, l;
		Character ch;
		int w, v, c;
		int spaceIdx;
		for(i = 0; i < n; i++) {
			s = arr[i];
			l = s.length();
			w = 0;
			v = 0;
			c = 0;
			spaceIdx = -1;
			for(j = 0; j < l; j++) {
				ch = s.charAt(j);
				if(ch == ' ') {
					if(spaceIdx != j - 1) {
						w++;
					}
					spaceIdx = j;
				} else if(VOWELS.contains(ch)) {
					v++;
				} else {
					c++;
				}
			}
			if(l > 0) {
				w++;
			}
			System.out.println(w+" "+v+" "+c);
		}
	}

	public static void main(String[] args) {
		VOWELS.add('a');
		VOWELS.add('e');
		VOWELS.add('i');
		VOWELS.add('o');
		VOWELS.add('u');
		Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine().trim());
        String[] arr = new String[t];
        for(int i = 0; i < t; i++) {
            arr[i] = in.nextLine().trim().toLowerCase();
        }
        in.close();
        solve(arr, t);
	}
}
