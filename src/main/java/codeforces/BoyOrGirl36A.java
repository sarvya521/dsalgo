package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BoyOrGirl36A {

    private static void solve(String input) {
        final long count = input.chars().distinct().count();
        if((count & 1) == 1) {
            System.out.println("IGNORE HIM!");
        } else {
            System.out.println("CHAT WITH HER!");
        }
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        solve(input);
        solve("wjmzbmr");
        solve("xiaodao");
        solve("sevenkplus");
    }
}
