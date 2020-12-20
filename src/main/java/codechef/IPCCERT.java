package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IPCCERT {

    private static boolean solve(String[] arr, int n, int m, int k) {
        int q = Integer.parseInt(arr[k]);
        if(q > 10) {
            return false;
        }
        long totalMin = 0;
        for(int i = 0; i < k; i++) {
            totalMin += Integer.parseInt(arr[i]);
        }
        if(totalMin < m) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int k = Integer.parseInt(arr[2]);
            int ans = 0;
            for(int i = 0; i < n; i++) {
                arr = br.readLine().split(" ");
                if(solve(arr, n, m, k)) {
                    ans ++;
                }
            }
            System.out.println(ans);
        }
    }
}
