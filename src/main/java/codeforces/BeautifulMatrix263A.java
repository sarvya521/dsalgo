package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeautifulMatrix263A {

    private static void solve(int[][] mat) {
        if(mat[2][2] == 1) {
            System.out.println(0);
            return;
        }
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(mat[i][j] == 1) {
                    int moves = 0;
                    moves = Math.abs(2 - i) + Math.abs(2 - j);
                    System.out.println(moves);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = 5;
            while(t > 0) {
                lines.add(br.readLine());
                t--;
            }
        }
        int[][] mat = new int[5][5];
        for(int i = 0; i < 5; i++) {
            mat[i] = Arrays.stream(lines.get(i).split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        solve(mat);
    }
}
