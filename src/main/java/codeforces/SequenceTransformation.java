package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SequenceTransformation {
    private static void solve(int[] arr) {
        int n = arr.length;
        final int min = Arrays.stream(arr).min().getAsInt();
        int count = 0;
        int l = 0;
        int r = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == min) {
                System.out.println(l+" - "+r);
                l = r = i+1;
                count++;
            } else {
                r = i;
            }
        }
        System.out.println(l+" - "+r);
        System.out.println("ans: "+count);
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
