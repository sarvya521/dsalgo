package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfNumbersFromRootToLeafPaths {
    private static final int M = (int)1e9+7;
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }

        public String toString() {
            return data+"";
        }
    }

    private static Node insert(Node root, int x) {
        if(root == null) {
            return new Node(x);
        }
        if(x < root.data) {
            root.left = insert(root.left, x);
        } else {
            root.right = insert(root.right, x);
        }
        return root;
    }

    private static Node bst(int[] arr, int n) {
        Node root = null;
        for(int i = 0; i < n; i++) {
            root = insert(root, arr[i]);
        }
        return root;
    }

    private static long solve(Node root, long val) {
        if(root == null) {
            return 0;
        }
        val = (val * (long)Math.pow(10, String.valueOf(root.data).length()) + root.data) % M;
        if(root.left == null && root.right == null) {
            return val;
        }
        return (solve(root.left, val) + solve(root.right, val)) % M;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Node root = bst(arr, n);
                builder.append(solve(root, 0)).append(System.lineSeparator());
            }
            System.out.println(builder);
        }
    }
}
