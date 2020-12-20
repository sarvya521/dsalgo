package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Candy1 {
    private static void solve(int a, int b, int c) {
        if (b - a == c - b) {
            System.out.println("AP " + (c + (c - b)));
        } else {
            System.out.println("GP " + (c * (c / b)));
        }
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            while (!line.equals("-1")) {
                int t = Integer.parseInt(line);
                int[] arr = new int[t];
                int sum = 0;
                for(int i = 0; i < t; i++) {
                    arr[i] = Integer.parseInt(br.readLine());
                    sum += arr[i];
                }
                if(sum % t != 0) {
                    System.out.println("-1");
                } else {
                    int c = sum / t;
                    int ans = 0;
                    for(int j = 0; j < t; j++) {
                        if(c > arr[j]) {
                            ans += c - arr[j];
                        }
                    }
                    System.out.println(ans);
                }
                line = br.readLine();
            }
        }
    }
}