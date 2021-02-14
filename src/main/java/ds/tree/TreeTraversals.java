package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TreeTraversals {

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

    private static void preOrder(Node root, StringBuilder builder) {
        if(root == null) {
            return;
        }
        builder.append(root).append(" ");
        preOrder(root.left, builder);
        preOrder(root.right, builder);
    }

    private static void inOrder(Node root, StringBuilder builder) {
        if(root == null) {
            return;
        }
        inOrder(root.left, builder);
        builder.append(root).append(" ");
        inOrder(root.right, builder);
    }

    private static void postOrder(Node root, StringBuilder builder) {
        if(root == null) {
            return;
        }
        postOrder(root.left, builder);
        postOrder(root.right, builder);
        builder.append(root).append(" ");
    }

    private static void solve(int[] arr, int n) {
        Node root = null;
        for(int i = 0; i < n; i++) {
            root = insert(root, arr[i]);
        }
        StringBuilder pre = new StringBuilder();
        preOrder(root, pre);
        StringBuilder in = new StringBuilder();
        inOrder(root, in);
        StringBuilder post = new StringBuilder();
        postOrder(root, post);
        System.out.println(pre+"\n"+in+"\n"+post+"\n");
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader input = new BufferedReader (new InputStreamReader(System.in))) {
            int t = Integer.parseInt(input.readLine());
            String[] queries = new String[t];
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(input.readLine());
                int[] arr = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                solve(arr, n);
            }
        }
    }
}
