package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class FLOW007 {

    private static void solve(List<String> numbers) {
        numbers.stream()
                .map(n -> new StringBuilder(n).reverse().toString())
                .mapToInt(Integer::parseInt)
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t > 0) {
                lines.add(br.readLine());
                t--;
            }
        }
        solve(lines);
    }
}
