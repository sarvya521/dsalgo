package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BytelandianCoin {

    private static Map<Long, Long> MAP = new HashMap<>();

    private static long solve(Long n) {
        if(n == 0) {
            return 0;
        }
        if(MAP.containsKey(n)) {
            return MAP.get(n);
        }
        long sum = solve(n/2) + solve(n/3) + solve(n/4);
        if(sum < n) {
            MAP.put(n, n);
            return n;
        } else {
            MAP.put(n, sum);
            return sum;
        }
    }

    private static void solve(List<Long> inputs) {
        for(Long n : inputs) {
            System.out.println(solve(n));
        }
    }

    public static void main(String[] args) throws Exception {
        List<Long> inputs = new ArrayList<>();
        int t = 10;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (t > 0) {
                final String n = br.readLine();
                if(n == null || "".equals(n)) {
                    break;
                }
                inputs.add(Long.parseLong(n));
                t --;
            }
        }
        solve(inputs);
    }
}