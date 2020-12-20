package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
    private static void withdraw(int x, double y) {
        if (x % 5 != 0 || x > y) {
            System.out.println(String.format("%.2f", y));
            return;
        }
        System.out.println(String.format("%.2f", y - x - 0.50));
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        final String[] arr = input.split(" ");
        withdraw(Integer.parseInt(arr[0]), Double.parseDouble(arr[1]));
    }
}