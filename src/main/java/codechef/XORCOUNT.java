package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class XORCOUNT {

    private static final long M = 998244353;

    private static long power(long a, long b) {
        long ans = 1;
        long x = a;
        while(b != 0) {
            if(b % 2 == 1) {
                //ans = (ans * x) % M;
                ans = ((ans % M) * (x % M)) % M;
            }
            //x = (x * x) % M;
            x = ((x % M) * (x % M)) % M;
            b = b >> 1;
        }
        return ans % M;
    }


    private static void solve(long l, long r, long a, long b, int k) {
        long ans = 0;
        if(k == 1) {
            ans = ((Math.min(r, b) % M - (Math.max(l, a) % M) + 1)+ M) % M;
            System.out.println(ans);
            return;
        }
        if(a < l && b > r) {
            long x = r - l + 1;
            ans = power (x, k);
            System.out.println(ans);
            return;
        }
        ans = ((Math.min(r, b) % M - (Math.max(l, a) % M) + 1)+ M) % M;
        ans = power(ans, k);
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        /*try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t > 0) {
                final String[] arr = br.readLine().split(" ");
                solve(Long.parseLong(arr[0]), Long.parseLong(arr[1]), Long.parseLong(arr[2]), Long.parseLong(arr[3]),
                        Integer.parseInt(arr[4]));
                t--;
            }
        }*/
        solve(26, 54, 18, 34, 1);
        solve(3, 5, 4, 7, 2);
        solve(2, 9, 0, 100, 3);
    }
}
