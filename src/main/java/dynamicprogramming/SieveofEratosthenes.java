package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class SieveofEratosthenes {
	static final int MAX_SIZE = 1000001;
    static List<Boolean> isprime = new ArrayList<Boolean>(MAX_SIZE);
    static List<Integer> prime = new ArrayList<Integer>();
    static List<Integer> SPF = new ArrayList<Integer>(MAX_SIZE);
      
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
     
    public static void main(String args[]) 
    {
    	 int N = 13 ; // Must be less than MAX_SIZE
         
         for (int i = 0; i < MAX_SIZE; i++){
             isprime.add(true);
             SPF.add(2);
         }
          
         manipulated_seive(N);
         
         System.out.println(prime);
       
         // pint all prime number less then N
         for (int i=0; i<prime.size() && prime.get(i) <= N ; i++)
             System.out.print(prime.get(i) + " ");
    }
}
