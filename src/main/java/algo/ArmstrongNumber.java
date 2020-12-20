package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArmstrongNumber {
    private static void checkIfArmstrongNumber(int n) {
        long sum = 0;
        int m = n;
        while(m != 0) {
            sum += Math.pow((m % 10), 3);
            m = m / 10;
        }
        System.out.println(sum == n ? "Yes" : "No");
    }

    public static void main(String[] args) throws Exception {
       /* String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        checkIfArmstrongNumber(Integer.parseInt(input));*/
        checkIfArmstrongNumber(153);
    }
}