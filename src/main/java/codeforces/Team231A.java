package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team231A {

    private static void solve(List<String> numbers) {
        List<Integer> allowed = Arrays.asList(3,5,6,7);
        final long ans = numbers.stream()
                .mapToInt(s -> Integer.parseInt(s.replaceAll("\\s", ""), 2))
                .filter(allowed::contains)
                .count();
        System.out.println(ans);
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
