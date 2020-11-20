package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StonesOnTable266A {

    private static void solve(String input) {
        final char[] chars = input.toCharArray();
        int count = 0;
        for(int i = 0; i < chars.length-1; i++) {
            if(chars[i] == chars[i+1]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();
            input = br.readLine();
        }
        solve(input);
        solve("RRG");
        solve("RRRRR");
        solve("BRBG");
    }
}
