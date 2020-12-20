package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhatsNextApGp {
    private static void solve(int a, int b, int c) {
        if (b - a == c - b) {
            System.out.println("AP " + (c + (c - b)));
        } else {
            System.out.println("GP " + (c * (c / b)));
        }
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            while (!line.equals("0 0 0")) {
                lines.add(line);
                line = br.readLine();
            }
        }
        lines.forEach(line -> {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            solve(arr[0], arr[1], arr[2]);
        });
    }
}