package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class FLOW004 {
    private static void solve(List<String> numbers) {
        numbers.stream()
                .map(number -> {
                    if(number.length() > 1) {
                        return Integer.parseInt(number.charAt(0)+"") + Integer.parseInt(number.charAt(number.length()-1)+"");
                    } else {
                        return Integer.parseInt(number);
                    }
                })
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine().trim());
            while (t > 0) {
                lines.add(br.readLine().trim());
                t--;
            }
        }
        solve(lines);
    }
}
