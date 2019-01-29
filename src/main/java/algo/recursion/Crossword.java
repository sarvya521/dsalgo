package algo.recursion;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Crossword {
	
	static String[] solve(String[] crossword, String[] result, String[] hints, int index, int count) {
		if(count == hints.length) {
			return result;
		}
		for(int i = 0; i < result.length; i++) {
			String s = result[i];
			int j = s.indexOf('-');
			if(j != -1) {
				
			}
		}
		return crossword;
	}
	
    static String[] crosswordPuzzle(String[] crossword, String hints) {
        String[] hintArray = hints.split(";");
        String[] result = crossword;
        //result = solve(crossword, result, hints, hintArray, new ArrayList<String>());
        return result;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        String[] crossword = new String[10];
        for(int crossword_i = 0; crossword_i < 10; crossword_i++){
            crossword[crossword_i] = in.next();
        }
        String hints = in.next();
        String[] result = crosswordPuzzle(crossword, hints);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();*/
    	System.out.println("+----++".replaceAll("-{4}", "aaaa"));
    }
}
