package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountBST {

    static int ANS = 0;
    private static boolean isBst(List<Integer> list, int i, int a, int b) {
        if (i >= list.size()) {
            return true;
        }
        return (list.get(i) > a && list.get(i) < b)
                && isBst(list, 2*i, a, list.get(i))
                && isBst(list, 2*i + 1, list.get(i), b);
    }

    private static int solve(List<Integer> list, int a, int b) {
        for(int i = 1; i < list.size(); i++) {
            if(isBst(list, i, a, b)) {
                ANS++;
            }
        }
        return ANS;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                List<Integer> list = new ArrayList<>();
                list.add(-1);
                Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(() -> list));
                ANS = 0;
                System.out.println(solve(list, Integer.MIN_VALUE, Integer.MAX_VALUE));
            }
        }
    }
}
