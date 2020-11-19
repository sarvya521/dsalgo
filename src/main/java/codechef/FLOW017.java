package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class FLOW017 {

    private static void solve(List<String> numbers) {
        numbers.stream()
                .mapToInt(Integer::parseInt)
                .forEach(n -> {
                    if(n < 10) {
                        System.out.println("Thanks for helping Chef!");
                    } else {
                        System.out.println("-1");
                    }
                });

        numbers.forEach(inputs -> {
            final String[] arr = inputs.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);

            if ((a > b && b > c) || (c > b && b > a)) {
                System.out.println(b);
            } else if ((a > c && c > b) || (b > c && c > a)) {
                System.out.println(c);
            } else {
                System.out.println(a);
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
