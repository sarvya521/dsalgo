package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class FCTRL2 {
    private static void factorial(int n) {
        int res[] = new int[500];

        res[0] = 1;
        int res_size = 1;

        for (int x = 2; x <= n; x++)
            res_size = multiply(x, res, res_size);

        for (int i = res_size - 1; i >= 0; i--)
            System.out.print(res[i]);
        System.out.println();
    }

    private static int multiply(int x, int res[], int res_size) {
        int carry = 0;
        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;
            carry = prod / 10;
        }

        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }

    private static void solve(List<String> numbers) {
        numbers.stream()
                .mapToInt(Integer::parseInt)
                .forEach(FCTRL2::factorial);
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
