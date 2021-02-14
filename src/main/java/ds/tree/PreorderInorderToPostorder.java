package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author sarvesh
 * @since
 */
public class PreorderInorderToPostorder {

    static int pos = 0;

    private static int search(int[] in, int x, int lo, int hi) {
        for(int i = lo; i <= hi; i++) {
            if(in[i] == x) {
                return i;
            }
        }
        return -1;
    }

    private static void solve(int[] in, int[] pre, int lo, int hi, StringBuilder builder) {
        if(lo > hi) {
            return;
        }
        int idx = search(in, pre[pos], lo, hi);
        pos++;
        solve(in, pre, lo, idx-1, builder);
        solve(in, pre, idx+1, hi, builder);
        builder.append(in[idx]).append(" ");
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                int[] pre = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                pos = 0;
                solve(in, pre, 0, n-1, builder);
                builder.append(System.lineSeparator());
            }
            System.out.println(builder);
        }
    }
}
