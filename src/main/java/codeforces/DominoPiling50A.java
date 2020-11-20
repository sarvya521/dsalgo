package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DominoPiling50A {

    private static void solve(int m, int n) {
        System.out.println((m * n)/2);
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        final String[] arr = input.split(" ");
        solve(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
    }
}
