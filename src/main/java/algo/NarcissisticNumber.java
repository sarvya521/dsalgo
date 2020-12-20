package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NarcissisticNumber {
    private static void checkIfNarcissisticNumber(int n) {
        int len = String.valueOf(n).length();
        long sum = 0;
        int m = n;
        while(m != 0) {
            sum += Math.pow((m % 10), len);
            m = m / 10;
        }
        System.out.println(sum == n ? "Yes" : "No");
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        checkIfNarcissisticNumber(Integer.parseInt(input));
    }
}