package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpecialPermutation {

    private static void solve(int n) {
        System.out.print(n + " ");
        for(int i = 1; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while(t > 0) {
                int n = Integer.parseInt(br.readLine());
                solve(n);
                t --;
            }
        }
    }
}
