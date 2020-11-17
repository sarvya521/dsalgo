package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class TriangleValidator {
    private static void validate(long a, long b, long c) {
        if ((a + b) > c &&
                (a + c) > b &&
                (b + c) > a) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    public static void main(String[] args) throws Exception {
        /*String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        String[] ip = input.split(" ");
        validate(Long.parseLong(ip[0]), Long.parseLong(ip[1]), Long.parseLong(ip[2]));*/
        validate(3, 4, 1);
    }
}
