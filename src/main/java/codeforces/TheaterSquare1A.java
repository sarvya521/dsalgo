package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TheaterSquare1A {
    private static void solve(String input) {
        final String[] arr = input.split(" ");
        long n = Integer.parseInt(arr[0]);
        long m = Integer.parseInt(arr[1]);
        long a = Integer.parseInt(arr[2]);

        long countn = n / a;
        long countm = m / a;

        if (n % a != 0)
            countn++;

        if (m % a != 0)
            countm++;

        System.out.println(countn * countm);
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            solve(br.readLine());
        }
    }
}
