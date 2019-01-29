package gametheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class GameOfLetters {
	
	static final String S = "Santa";
	static final String B = "Banta";

	public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        while(n > 0) {
        	Set<Character> charsSet = input.readLine().chars().mapToObj(e->(char)e).collect(Collectors.toSet());
        	if(charsSet.size() % 2 == 0) {
        		System.out.println(B);
        	} else {
        		System.out.println(S);
        	}
        	n--;
        }
        input.close();
    }

}
