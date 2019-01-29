package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AStringSubsequenceInBString {
	
	/*private static final String Y = "Yes";
	private static final String N = "No";
	
	private static void solve(String a, String b) {
		int i = 0, j = 0, m, n;
		m = a.length();
		n = b.length();
		for(;i < n && j < m; i++) {
			if(a.charAt(j) == b.charAt(i)) {
				j++;
			}
		}
		if(j == m) {
			System.out.println(Y);
		} else {
			System.out.println(N);
		}
	}
	
	private static void solve(String[] queries) {
		String[] arr = null;
		for(String query : queries) {
			arr = query.split(" ");
			solve(arr[0], arr[1]);
		}
	}

	public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		String[] queries = new String[t];
		for(int i = 0; i < t; i++) {
			queries[i] = input.readLine().trim();
		}
		input.close();
		solve(queries);
    }*/
	
	public static void main(String args[] ) throws Exception {
        /*BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.readLine().trim();
        }
        int q = Integer.parseInt(input.readLine());
        String[] queries = new String[n];
        for(int i = 0; i < n; i++) {
            queries[i] = input.readLine().trim();
        }*/
		
		solve(new String[]{"harsh", "fun", "college"}, new String[]{"collegefun"});
    }
    
    static void solve(String[] arr, String[] queries) {
        for(String query : queries) {
            solve(arr, query);
        }
    }
    
    static void solve(String[] arr, String a) {
    	int i = 0, j = 0, m, n;
    	m = a.length();
    	
    	for(String b: arr) {
    		n = b.length();
    		
    		for(;j < n && i < m; i++) {
    			if(a.charAt(i) == b.charAt(j)) {
    				j++;
    				i++;
    			} else {
    				break;
    			}
    		}
    		
			if(j == n) {
    			j = 0;
    		} else {
    			i = 0;
    		}
    	}
    	
    }

}
