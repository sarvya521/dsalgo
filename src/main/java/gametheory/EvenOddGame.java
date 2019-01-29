package gametheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EvenOddGame {

	public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        input.close();
        if((n & 1) == 1) {
        	System.out.println("Ehab");
        } else {
        	System.out.println("Mahmoud");
        }
    }

}
