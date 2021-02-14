package ds.trie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumXOR {

    static class Node {
        Node[] c;

        Node() {
            c = new Node[2];
        }
    }

    static int log2(int N) {
        return (int)(Math.log(N) / Math.log(2));
    }

    static int max(int[] arr, int n) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    private static boolean checkBit(int n, int i) {
        while (i > 0) {
            n = n >> 1;
            i--;
        }
        return (n & 1) == 1;
    }

    static void insert(Node root, int x, int bits) {
        for (int i = bits; i >= 0; i--) {
            int bv = checkBit(x, i) ? 1 : 0;
            if (root.c[bv] == null) {
                root.c[bv] = new Node();
            }
            root = root.c[bv];
        }
    }

    static int solve(Node root, int x, int bits) {
        int ans = 0;
        for (int i = bits; i >= 0; i--) {
            int bv = checkBit(x, i) ? 1 : 0;
            if (root.c[1 - bv] != null) {
                ans = ans + (1 << i);
                root = root.c[1 - bv];
            } else {
                root = root.c[bv];
            }
        }
        return ans;
    }

    static void solve(int[] arr, int n) {
        Node root = new Node();
        int bits = log2(max(arr, n));
        for (int i = 0; i < n; i++) {
            insert(root, arr[i], bits);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(root, arr[i], bits));
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(Math.log(2));
//        System.out.println(Math.log(4));
//        System.out.println(Math.log(8));
//        System.out.println(Math.log(16));
//        System.out.println(Math.log(32));
//        System.out.println(Math.log(35));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                solve(arr, n);
            }
        }
//        int n = 5;
//        int[] arr = new int[]{13, 11, 35, 3, 32};
//        solve(arr, n);
    }
}
