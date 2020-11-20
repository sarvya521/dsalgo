package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextRound158A {

    private static void solve(int n, int k, int[] arr) {
        int ans = 0;
        int key = arr[k - 1];

        for (int j = 0; j < n; j++) {
            if (arr[j] >= key && arr[j] > 0) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            lines.add(br.readLine());
            lines.add(br.readLine());
        }
        final String[] arr = lines.get(0).split(" ");
        solve(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]),
                Arrays.stream(lines.get(1).split(" ")).mapToInt(Integer::parseInt).toArray());
    }
}
