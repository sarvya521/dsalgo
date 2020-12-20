package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberSteps {
    private static void solve(int a, int b) {
        if (a != b && a - b != 2) {
            System.out.println("No Number");
            return;
        }
        if (a % 2 == 0 && b % 2 == 0)
            System.out.println(a + b);
        else
            System.out.println(a + b - 1);

    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t > 0) {
                lines.add(br.readLine());
                t--;
            }
        }
        lines.forEach(line -> {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            solve(arr[0], arr[1]);
        });
    }
}