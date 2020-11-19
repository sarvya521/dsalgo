package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class WayToLongWords71A {

    private static void solve(List<String> lines) {
        lines.forEach(word -> {
            if(word.length() > 10) {
                System.out.println(String.valueOf(word.charAt(0)) + (word.length() - 2) + String.valueOf(word.charAt(word.length()-1)));
            } else {
                System.out.println(word);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while(t > 0) {
                lines.add(br.readLine());
                t--;
            }
        }
        solve(lines);
    }
}
