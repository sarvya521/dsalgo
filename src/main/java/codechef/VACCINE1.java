package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VACCINE1 {

    private static int solve(int d1, int v1, int d2, int v2, int p) {
        int ans = 0;
        int totalVaccines = 0;
        if(d1 == d2) {
            totalVaccines = v1 + v2;
            ans++;
        } else if(d2 > d1) {
            ans = d1;
            totalVaccines = v1;
            for(int i = 1; i < d2-d1; i++) {
                totalVaccines += v1;
                if(totalVaccines > p) {
                    break;
                }
                ans++;
            }
        } else {
            ans = d2;
            totalVaccines = v2;
            for(int i = 1; i < d1-d2; i++) {
                totalVaccines += v2;
                if(totalVaccines > p) {
                    break;
                }
                ans++;
            }
        }
        while(totalVaccines < p) {
            totalVaccines += v1+v2;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final String[] arr = br.readLine().split(" ");
            int D1 = Integer.parseInt(arr[0]);
            int V1 = Integer.parseInt(arr[1]);
            int D2 = Integer.parseInt(arr[2]);
            int V2 = Integer.parseInt(arr[3]);
            int P = Integer.parseInt(arr[4]);
            System.out.println(solve(D1, V1, D2, V2, P));
        }
    }
}
