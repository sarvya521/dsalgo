package algo.recursion;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PowerSum {
	
	static int sum(int x, int n, int sum, int i, int count) {
		if(sum == x) {
			return count + 1;
		}
		int j = i;
		int s = (int)Math.pow(j, n) + sum;
		while(s <= x) {
			count = sum(x, n, s, j + 1, count);
			s = (int)Math.pow(j+1, n) + sum;
			j++;
		}
		return count;
	}

	static int powerSum(int x, int n) {
		return sum(x, n, 0, 1, 0);
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int N = in.nextInt();
        int result = powerSum(X, N);
        System.out.println(result);
        in.close();*/
    	
    	int x = 25; 
        int n = 2;
        int result = powerSum(x, n);
        System.out.println(result);
        
        
    }
    
}
