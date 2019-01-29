package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfSubarrays {
	
	static int[] prepareCommulitiveSum(int[] arr, int n) {
		int[] comms = new int[n+1];
		comms[0] = 0;
		for(int i = 1; i <= n; i++) {
			comms[i] = comms[i-1]+arr[i-1];
		}
		return comms;
	}
	
	static void solve(int[] arr, int n, String[] queries, int q) {
		int[] comms = prepareCommulitiveSum(arr, n);
		//System.out.println(Arrays.stream(comms).boxed().collect(Collectors.toList()));
		int a, b;
		String[] query;
		for(int i = 0; i < q; i++) {
			query = queries[i].split(" ");
			a = Integer.parseInt(query[0]);
			b = Integer.parseInt(query[1]);
			//System.out.println(a+"-"+b+"="+(comms[b+1] - comms[a]));
			System.out.println(comms[b+1] - comms[a]);
		}
	}

	public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] arr = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int q = Integer.parseInt(input.readLine());
        String[] queries = new String[q];
        for(int i = 0; i < q; i++) {
        	queries[i] = input.readLine();
        }
        input.close();
        solve(arr, n, queries, q);
    }

}
