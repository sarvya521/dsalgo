package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ColorfulBuildings {
    
    private static void solve(int[][] queries, int t) {
        for(int i = 0; i < t; i++) {
            int N = queries[i][0];
            int K = queries[i][1];
            if(N == 1){
                System.out.println(K);
                continue;
            }
            long ans = K;
            for(int j = 1; j < N; j++) {
                ans = (ans * (K-1)) % 1000000007;
            }
            System.out.println(ans);
        }
    }
    
    public static void main(String args[] ) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        int[][] queries = new int[t][2];
        for (int i = 0; i < t; i++) {
			String[] str = input.readLine().trim().split(" ");
			queries[i][0] = Integer.parseInt(str[0]);
			queries[i][1] = Integer.parseInt(str[1]);
		}
        input.close();
        solve(queries, t);
    }
}
