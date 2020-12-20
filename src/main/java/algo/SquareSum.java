package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SquareSum {
    private static void squaresum(int n) {
        long sum = (n * (n + 1) * (2 * n + 1)) / 6;
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        squaresum(Integer.parseInt(input));
    }
}