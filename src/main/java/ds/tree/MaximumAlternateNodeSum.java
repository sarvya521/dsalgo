package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumAlternateNodeSum {

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

    static int sum(Node root) {
        if (root == null)
            return 0;

        return Math.max(alternateSum(root), (alternateSum(root.left) + alternateSum(root.right)));
    }

    static int alternateSum(Node root) {
        if (root == null)
            return 0;

        int sum = root.data;
        if (root.left != null) {
            sum += sum(root.left.left);
            sum += sum(root.left.right);
        }

        if (root.right != null) {
            sum += sum(root.right.left);
            sum += sum(root.right.right);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Node root = bst(arr, n);
                System.out.println(sum(root));
            }
        }
    }
}
