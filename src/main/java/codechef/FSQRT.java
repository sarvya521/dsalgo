package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class FSQRT {

    private static void solve(List<String> numbers) {
        numbers.stream()
                .mapToInt(n -> (int)Math.sqrt(Double.parseDouble(n)))
                .forEach(System.out::println);
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
