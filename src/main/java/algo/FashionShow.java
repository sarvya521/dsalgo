package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FashionShow {
    private static void solve(List<String> input) {
        for(int i = 0; i < input.size(); i = i + 2) {
            final long[] arr1 = Arrays.stream(input.get(i).split(" ")).mapToLong(Long::parseLong).sorted().toArray();
            final long[] arr2 = Arrays.stream(input.get(i+1).split(" ")).mapToLong(Long::parseLong).sorted().toArray();
            long sum = 0;
            for(int j = 0; j < arr1.length; j++) {
                sum += arr1[j] * arr2[j];
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t > 0) {
                br.readLine(); // n
                lines.add(br.readLine());
                lines.add(br.readLine());
                t --;
            }
        }
        solve(lines);
    }
}