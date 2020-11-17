package algo.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RobinCarp2 {

	public final static int R = 256;
	static final int Q1 = 101;
	static final int Q2 = 103;
	
	static boolean check(String pat, String txt, int i, int M) {
		for (int j = 0; j < M; j++) {
			if (pat.charAt(j) != txt.charAt(i + j)) {
				return false;
			}
		}
		return true;
	}
	
	static long hash(String key, int M, int Q) {
		long h = 0;
		for (int j = 0; j < M; j++) {
			h = (R * h + key.charAt(j)) % Q;
		}
		return h;
	}

	static long solve(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		if (N < M) {
			return 0;
		}
		
		long count = 0;		
		
		int i;
		
		long RM1 = 1;
		for (i = 1; i <= M-1; i++) { 
			RM1 = (R * RM1) % Q1;
		}
		
		long RM2 = 1;
		for (i = 1; i <= M-1; i++) { 
			RM1 = (R * RM2) % Q1;
		}
		
		long patHash1 = 0, patHash2 = 0, txtHash1 = 0, txtHash2 = 0; 
		
		patHash1 = hash(pat, M, Q1);
		txtHash1 = hash(txt, M, Q1);
		patHash2 = hash(pat, M, Q2);
		txtHash2 = hash(txt, M, Q2);
		
		if ((patHash1 == txtHash1) && check(pat, txt, 0, M)) {
			if((patHash2 == txtHash2) && check(pat, txt, 0, M)) {
				count++;
			}
		}
		
		for (i = M; i < N; i++) {
			txtHash1 = (txtHash1 + Q1 - RM1 * txt.charAt(i - M) % Q1) % Q1; 
            txtHash1 = (txtHash1 * R + txt.charAt(i)) % Q1;
            
            int offset = i - M + 1;
            if ((patHash1 == txtHash1)) {
            	txtHash2 = (txtHash2 + Q1 - RM2 * txt.charAt(i - M) % Q2) % Q2; 
                txtHash2 = (txtHash2 * R + txt.charAt(i)) % Q2;
            	if((patHash2 == txtHash2) && check(pat, txt, offset, M)) {
            		count++;
            	}
            }
		}
		return count;
	}

	static void solve(int t, String[][] queries) {
		String[] arr = null;
		for (int i = 0; i < t; i++) {
			arr = queries[i];
			System.out.println(solve(arr[0], arr[1]));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		int i;
		String[][] queries = new String[t][2];
		for (i = 0; i < t; i++) {
			queries[i] = input.readLine().trim().split(" ");
		}
		input.close();
		solve(t, queries);
		/*
4
smart yekicmsmartplrplsmartrplplmrpsmartrpsmartwmrmsmartsmart
interviews interviewseiwcombvinterviewskrenlzp
ds dsdsajdsrjjdsjjj
algo yalgoalgoalgopalgoaxalgoasaxalgolalgoalgoalgo
		 */
	}

}
