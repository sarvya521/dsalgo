package gametheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrimeCoin {
	
	static final String S = "Santa";
	static final String B = "Banta";

	public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int p = 0;
        while(n > 0) {
        	p = Integer.parseInt(input.readLine());
        	if(p % 6 == 0) {
        		System.out.println(B);
        	} else {
        		System.out.println(S);
        	}
        	n--;
        }
        input.close();
    }

}
