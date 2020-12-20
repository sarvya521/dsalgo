package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueBidAuction {

    private static void solve(int[] arr) {
        final Map<Integer, Long> map =
                Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i = 0; i < n; i++) {
            if(map.get(arr[i]) == 1 && arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }
        if(minIdx != -1) {
            minIdx = minIdx + 1;
        }
        System.out.println(minIdx);
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while(t > 0) {
                br.readLine();
                int[] arr =
                        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                solve(arr);
                t --;
            }
        }
    }
}
