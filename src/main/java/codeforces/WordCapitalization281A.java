package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WordCapitalization281A {

    private static void solve(String input) {
        final char[] chars = input.toCharArray();
        chars[0] = String.valueOf(chars[0]).toUpperCase().charAt(0);
        System.out.println(new String(chars));
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        solve(input);
        solve("ApPLe");
        solve("konjac");
    }
}
