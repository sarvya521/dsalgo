package algo.bitwise;

import java.util.Scanner;

public class BinaryConverter {
	
   /* static String binary(int n) {
		String str = "";
		int div = 0;
		int rem = 0;
		while(n != 1) {
			div = n / 2;
			rem = n % 2;
			n = div;
			str = rem + str;
		}
		str = 1 + str;
		return str;
	}*/
    
    static void binary(int n) {
    	String str = "";
    	while(n != 0) {
    		if((n & 1) == 1) {
    			str = 1 + str;
    		} else {
    			str = 0 + str;
    		}
    		n = n >> 1;
    	}
    	System.out.println(str);
	}
    
    /*static void binary(int[] arr) {
		String str = binary(arr[0]);
		for(int i = 1; i < arr.length; i++) {
			int n = arr[i];
			if(n == arr[i-1]) {
				System.out.println(str);
				continue;
			}
			str = "";
			int div = 0;
			int rem = 0;
			while(n != 1) {
				div = n / 2;
				rem = n % 2;
				n = div;
				str = rem + str;
			}
			str = 1 + str;
			System.out.println(str);
		}
		
	}*/
    
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            System.out.println(binary(n));
        }
        in.close();
    }*/

	public static void main(String[] args) {
		//binary(new int[]{13,13,13,13,15});
		binary(0);
	}

}
