package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HelpfulMaths339A {

    private static void solve(String input) {
        if(input.length() == 1) {
            System.out.println(input);
            return;
        }
        input = input.replaceAll("\\+", "");
        final char[] chars = input.toCharArray();
        Arrays.sort(chars);
        char[] ans = new char[(chars.length * 2)-1];
        for(int i = 0, j = 0; i < chars.length - 1; i++, j = j + 2) {
            ans[j] = chars[i];
            ans[j+1] = '+';
        }
        ans[ans.length-1] = chars[chars.length-1];
        final String string = new String(ans);
        System.out.println(string);
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        solve(input);
        solve("3+2+1");
        solve("1+1+3+1+3");
        solve("2");
    }
}
