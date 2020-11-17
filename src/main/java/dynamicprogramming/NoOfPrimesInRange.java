package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoOfPrimesInRange {
	static final int MAX_SIZE = 1000001;
    static List<Boolean> isprime = new ArrayList<>(MAX_SIZE);
    static List<Integer> prime = new ArrayList<>();
    static List<Integer> SPF = new ArrayList<>(MAX_SIZE);
      
	static void manipulated_seive(int N) {
		isprime.set(0, false);
		isprime.set(1, false);

		for (int i = 2; i <= N; i++) {
			if (isprime.get(i)) {
				prime.add(i);
				SPF.set(i, i);
			}

			for (int j = 0; j < prime.size() && i * prime.get(j) < N && prime.get(j) <= SPF.get(i); j++) {
				isprime.set(i * prime.get(j), false);
				SPF.set(i * prime.get(j), prime.get(j));
			}
		}
	}
	
	private static void solve(int[][] queries) {
		for(int[] query : queries) {
			int a = query[0];
	        int b = query[1];
	        
	        int count = 0;
	        for (int i=0; i<prime.size() && prime.get(i) <= b; i++) {
	        	if(prime.get(i) >= a) {
	                count++;
	        	}
	        }
	        System.out.println(count);
		}
	}
     
    public static void main(String args[]) throws Exception {
        for (int i = 0; i < MAX_SIZE; i++){
            isprime.add(true);
            SPF.add(2);
        }
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		int[][] queries = new int[t][];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < t; i++) {
			queries[i] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
			if(queries[i][1] > max) {
				max = queries[i][1];
			}
		}
		input.close();
		manipulated_seive(max);
        System.out.println(prime);
		solve(queries);
    }
    
}
