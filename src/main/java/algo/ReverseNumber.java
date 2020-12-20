package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseNumber {
    private static void reverse(int a, int b) {
        final int sum = Integer.parseInt(new StringBuilder().append(a).reverse().toString())
                +
                Integer.parseInt(new StringBuilder().append(b).reverse().toString());
        System.out.println(Integer.parseInt(new StringBuilder().append(sum).reverse().toString()));
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
            reverse(arr[0], arr[1]);
        });
    }
}