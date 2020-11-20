package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Football96A {

    private static void solve(String input) {
        final char[] chars = input.toCharArray();
        int count0 = 0;
        int count1 = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '0') {
                count0 = 0;
                count1 ++;
            } else {
                count1 = 0;
                count0 ++;
            }
            if(count0 == 7 || count1 == 7) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        solve(input);
        solve("001001");
        solve("1000000001");
    }
}
