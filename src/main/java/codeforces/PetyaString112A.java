package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PetyaString112A {

    private static void solve(String str1, String str2) {
        final int i = str1.toLowerCase().compareTo(str2.toLowerCase());
        if(i < 0) {
            System.out.println(-1);
        } else if(i > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws Exception {
        String str1 = null;
        String str2 = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            str1 = br.readLine();
            str2 = br.readLine();
        }
        solve(str1, str2);
        /*solve("aaaa", "aaaA");
        solve("abs", "Abz");
        solve("abcdefg", "AbCdEfF");*/
    }
}
