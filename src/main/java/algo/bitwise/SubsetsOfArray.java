package algo.bitwise;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubsetsOfArray {

    private static void solve(int[] arr, int n, int k) {
        int m = 1 << n;
        for(int i = 0; i < m; i++) {
            int j = i;
            int sum = 0;
            int idx = 0;
            while(j != 0) {
                if((j & 1) == 1) {
                    sum += arr[idx];
                }
                j = j >> 1;
                idx++;
            }
            if(sum == k) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                String[] iparr = br.readLine().split(" ");
                int n = Integer.parseInt(iparr[0]);
                int k = Integer.parseInt(iparr[1]);
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                solve(arr, n , k);
            }
        }
    }
}
