package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class Watermelon4A {

    private static void solve(int number) {
        if(number > 2) {
            if(number % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("No");
            }
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            solve(Integer.parseInt(br.readLine()));
        }
    }
}
