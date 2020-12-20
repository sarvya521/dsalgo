package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Feynman {
    private static void solve(int a) {
        System.out.println((a*(a+1)*(2*a+1))/6);
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            while (!line.equals("0")) {
                lines.add(line);
                line = br.readLine();
            }
        }
        lines.forEach(line -> {
            solve(Integer.parseInt(line));
        });
    }
}