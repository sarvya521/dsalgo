package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CubeSum {
    private static void cubesum(int n) {
        long sum = 0;
        if (n % 2 == 0) {
            sum = ((n / 2) * (n + 1)) * ((n / 2) * (n + 1));
        } else {
            sum = (n * ((n + 1) / 2)) * (n * ((n + 1) / 2));
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        String input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
        }
        cubesum(Integer.parseInt(input));
    }
}