package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class FLOW001 {

    private static void solve(List<String> numbers) {
        numbers.stream()
                .map(line -> Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).sum())
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine().trim());
            while(t > 0) {
                lines.add(br.readLine().trim());
                t--;
            }
        }
        solve(lines);
    }
}
