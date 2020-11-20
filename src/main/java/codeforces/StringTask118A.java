package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringTask118A {

    private static void solve(String str) {
        str = str.toLowerCase();
        str = str.replaceAll("[aeiouy]", "");
        char[] ans = new char[str.length()*2];
        for(int i = 0, j = 0; i < str.length(); i++, j = j+2) {
            ans[j] = '.';
            ans[j+1] = str.charAt(i);
        }
        System.out.println(new String(ans));
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        solve(input);
        /*String input = "abcedefhijaabbcciijj";
        System.out.println(input.replaceAll("[aeiou]", ""));*/
    }
}
