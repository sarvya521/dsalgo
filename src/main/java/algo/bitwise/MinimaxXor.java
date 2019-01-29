package bitwise;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinimaxXor {
	
	static int highestBit(int n) {
		int highestSetBitIndex = 0;
		int index = 0;
		while(n != 0) {
			if((n & 1) == 1) {
				highestSetBitIndex = index;
			}
			index++;
			n = n >> 1;
		}
		return 1<<highestSetBitIndex;
	}

	
	static void anotherMinimaxProblem(int[] a) {
        for(int i = 0; i < a.length; i++) {
        	for(int j = i+1; j < a.length; j++) {
        		System.out.println(a[i]+": "+Integer.toBinaryString(a[i])+" - "+a[j]+": "+Integer.toBinaryString(a[j])+" ^ "+(a[i]^a[j]));
        	}
        }
		/*int n = a.length;
		for(int i = 0; i < 1<<n; i++) {
			int index = 0;
			int j = i;
			while(j != 0) {
				if((j & 1) == 1) {
					System.out.print(a[index]+" ");
				}
				index++;
				j = j >> 1;
			}
			System.out.println();
		}*/
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int max = 0;
        int e = 0;
        for(int a_i = 0; a_i < n; a_i++){
        	e = in.nextInt();
            a[a_i] = e;
            if(e > max) {
            	max = e;
            }
        }
        int result = anotherMinimaxProblem(a, e);
        System.out.println(result);
        in.close();*/
        int[] a = new int[]{1, 2, 3};
        anotherMinimaxProblem(a);
    }

}
