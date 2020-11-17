package dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PrimeFear {
	static final int MAX_SIZE = 1000001;
	static List<Boolean> isprime = new ArrayList<>(MAX_SIZE);
	static List<Integer> prime = new ArrayList<>();
	static List<Integer> SPF = new ArrayList<Integer>();
	
    static Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
    static List<Integer> queries = new ArrayList<Integer>();
    static List<Integer> fears = new ArrayList<Integer>();
    
    
    static void solve(int n) {
    	String str = null;
		
    	isprime.set(0, false);
		isprime.set(1, false);

		for (int i = 2; i < n; i++) {
			if (isprime.get(i)) {
				prime.add(i);
				SPF.set(i, i);
			}

			for (int j = 0; j < prime.size() && i * prime.get(j) < n && prime.get(j) <= SPF.get(i); j++) {
				isprime.set(i * prime.get(j), false);
				SPF.set(i * prime.get(j), prime.get(j));
			}
		}
		
		System.out.println(prime);
		
		int i = 2;
		for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
			int q = entry.getKey();
			for(;i <= q; i++) {
				if (isprime.get(i)) {
					//System.out.println(i);
					str = String.valueOf(i);
					if(str.indexOf("0") != -1) {
						continue;
					} else if(str.length() > 1 && fears.indexOf(Integer.parseInt(str.substring(1))) != -1) {
						fears.add(i);
						continue;
					}
					int k = 1;
					for(; k < str.length(); k++) {
						if(false == isprime.get(Integer.parseInt(str.substring(k)))) {
							break;
						}
					}
					if(k == str.length()) {
						fears.add(i);
					}
				}
			}
			map.put(q, fears.size());
		}
		
		/*System.out.println("\nfears == ");
		System.out.println(fears);
		System.out.println(map);*/
		
		for(int q : queries) {
			System.out.println(q+"-"+map.get(q));
        }
	}
    
    public static void main(String[] args) {
    	/*
    	int e = 0, t, max = Integer.MIN_VALUE;
    	
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t > 0) {
            e = in.nextInt();
            queries.add(e);
            map.put(e, 0);
            if(e > max) {
                max = e;
            }
            t--;
        }
        in.close();*/
    	
    	/*for(int i = 1; i <= 1000; i++) {
    		queries.add(i);
            map.put(i, 0);
    	}*/
    	
    	for (int i = 0; i < MAX_SIZE; i++){
            isprime.add(true);
            SPF.add(2);
        }
    	
        queries.add(5);
        map.put(5, 0);
        
        queries.add(200);
        map.put(200, 0);
        
        queries.add(30);
        map.put(30, 0);
        
        int max = Collections.max(queries);
        
        solve(max);
    }
}
