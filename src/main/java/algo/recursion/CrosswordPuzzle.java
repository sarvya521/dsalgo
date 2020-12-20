package algo.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CrosswordPuzzle {

	private static final char[][] puzzle = new char[10][10];
	private static String[] words;
	private static boolean[] visitedWords;

	private static int getIndexOfWordOfLength(int length) {
		for(int i = 0; i < words.length; i++) {
			String str = words[i];
			if(str.length() == length) {
				return i;
			}
		}
		return -1;
	}

	private static List<Integer> getIndexesOfWordOfLength(int length) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < words.length; i++) {
			String str = words[i];
			if(str.length() == length) {
				list.add(i);
			}
		}
		return list;
	}

	private static boolean isValidEmptySpaceInRow(int i, int j, int rowIdx) {
		for(int s = i; s <= j; s++) {
			if(puzzle[rowIdx][s] != '-') {
				return false;
			}
		}
		return true;
	}

	private static boolean isValidEmptySpaceInColumn(int i, int j, int colIdx) {
		for(int s = i; s <= j; s++) {
			if(puzzle[s][colIdx] != '-') {
				return false;
			}
		}
		return true;
	}


	private static void solve(int i, int j, int m, int n, int k) {
		if(i == m) {
			if(isValidEmptySpaceInRow(j, n, i)) {

			}
		} else if(j == n) {
			if(isValidEmptySpaceInRow(i, m, j)) {

			}
		}
	}

	/*private static void solve() {
		for(int row = 0; row < 10; row++) {
			for(int i = 0; i < 10; i++) {
				if(puzzle[row][i] == '-') {
					int j = i + 1;
					while(j < 10) {
						if (puzzle[row][j] != '-') {
							j = j - 1;
							break;
						}
						j++;
					}
					int len = j - i + 1;
					final List<Integer> wordIdx = getIndexesOfWordOfLength(len);
					i = j - 1;
					continue;
				}
			}
		}
	}*/

	static List<String> visitedWordList = new ArrayList<>();

	private static boolean solve(int currentVisitedWordIdx) {
		if(currentVisitedWordIdx == words.length) {
			return visitedWordList.size() == words.length;
		}
		final String word = words[currentVisitedWordIdx];
		int n = word.length();
		visitedWordList.add(word);
		if(!solve(currentVisitedWordIdx++)) {
			visitedWordList.remove(word);
		}
		return false;
	}

	private static void fitWordInRow(String word, int n) {
		for(int row = 0; row < 10; row++) {
			boolean canFitInThisRow = false;
			for(int col = 0; col <= 10-n; col++) {
				if(puzzle[row][col] == '-') {

				}
			}
		}
	}

    public static void main(String[] args) throws Exception {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			for(int i = 0; i < 10; i++) {
				puzzle[i] = br.readLine().toCharArray();
			}
			words = br.readLine().split(";");
			visitedWords = new boolean[words.length];
		}
    }
}
