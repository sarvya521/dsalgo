package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExpressAsApowB {

	static final String Y = "Yes";
    static final String N = "No";
    static Set<Integer> set = new HashSet<Integer>();
    static void solveBinary(int[] arr, int max) {
    	Set<Integer> set = new HashSet<Integer>();
    	int m = (int)Math.sqrt(max);
    	for (int x = 2; x <= m; x++) {
    		int lo = 2;
        	int hi = 30;
        	int num = 0;
        	int mid = 0;
        	while(lo <= hi) {
        		mid = lo+(hi-lo+1)/2;
        		num = (int)Math.pow(x, mid);
        		set.add(num);
        		if(num == max) {
        			break;
        		}
        		if(num > max) {
        			hi = mid - 1;
        		} else {
        			lo = mid + 1;
        		}
        	}
    	}
    	StringBuilder builder = new StringBuilder();
        for(int i : arr) {
            builder.append(set.contains(i) ? Y : N).append("\n");
        }
        System.out.print(builder);
    }

    static void solve() { // this funtion will be executed only once
    	int max = 10000000;
        int m = (int)Math.sqrt(max);
        int count = 1110;
        for (int x = 1001; x <= m; x++) { //  check for largest number only
        	int p = x;
            while ((p = p * x) <= max) {
            	set.add(p);
            	//count++;
            }
        }
        System.out.println(set.size());
        System.out.println(m);
        System.out.println(Collections.max(set));
    }
    
    public static void main(String[] args) throws Exception{
    	solve();
        /*BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        int[] arr = new int[t];
        for(int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }
        input.close();
        StringBuilder builder = new StringBuilder();
        for(int i : arr) {
            builder.append(set.contains(i) ? Y : N).append("\n");
        }
        System.out.print(builder);*/
    }
    
    static String solve(int max) { // this funtion will be executed only once
        int m = (int)Math.sqrt(max);
        for (int x = 2; x <= m; x++) { //  check for largest number only
        	int p = x;
            while ((p = p * x) <= max) {
            	if(p == max)
            		return Y;
            }
        }
        return N;
    }
    
    public static String check(int a) {
    	int factor = 2;
    	int m = (int)Math.sqrt(a);
    	while (factor <= m) {
    		int number = a;
    		while (number % factor == 0) {
    			number /= factor;
    		}
    		if (number == 1) {
    			return Y;
    		} else {
    			factor++;
    		}
    	}
    	return N;
    }
    
    public static String check2(int a) {
    	int m = (int)Math.sqrt(a);
        for (int i = 2; i <= m; i++) { //  check for largest number only
        	double value = Math.log(a) / Math.log(i);
        	if ((value - (int) value) < 0.000000001) {
        		return Y;
        	}
        }
        return N;
    }
    
    /*static String algo(int n) {
    	int a, b, c, m, p;
    	b = 2;
    	while((1<<b) <= n) {
    		a = 1;
    		c = n;
    		while(c-a >= 2) {
    			m = (a+c)/2;
    			p = (int)Math.min(Math.pow(m, b), n+1);
    			if(p == n) {
    				return Y;
    			} else if(p < n){
    				a = m;
    			} else {
    				c = m;
    			}
    		}
    		b = b + 1;
    	}
    	return N;
    }*/

}
