package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class LUCKFOUR {
    private static void solve(List<String> numbers) {
        numbers.stream()
                .map(number -> number.chars().filter(ch -> ch == '4').count())
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t > 0) {
                System.out.println(new StringBuilder(br.readLine()).reverse());
                t--;
            }
        }
        solve(lines);
    }
}
