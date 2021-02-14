package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class ComputeNcR {

    static final int P = (int)1e9 + 7;

    static int[][] dp;

    static int solve(int N, int R) {
        dp = new int[N + 1][R + 1];
        for (int i = 0; i <= N; i++) {
            int k = Math.min(i, R);
            for (int j = 0; j <= k; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = ((dp[i - 1][j - 1]) % P + (dp[i - 1][j]) % P) % P;
                }
            }
        }
        return dp[N][R];
    }

    public static void main(String[] args) throws Exception {
        solve(2000, 2000);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < t; i++) {
                final String[] ip = br.readLine().split(" ");
                int N = Integer.parseInt(ip[0]);
                int R = Integer.parseInt(ip[1]);
                builder.append(dp[N][R]).append(System.lineSeparator());
            }
            System.out.println(builder);
        }
    }
}
