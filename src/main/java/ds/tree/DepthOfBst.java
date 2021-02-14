package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DepthOfBst {

    static class Node {
        int data;
        int depth;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    private static int getDepth(Node root, int x) {
        if(root == null) {
            return 0;
        }
        if(root.data == x) {
            return root.depth;
        }
        if(x < root.data) {
            return getDepth(root.left, x);
        } else {
            return getDepth(root.right, x);
        }
    }

    private static void fillDepth(Node root, int d) {
        if(root == null) {
            return;
        }
        root.depth = d;
        fillDepth(root.left, d+1);
        fillDepth(root.right, d+1);
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
        fillDepth(root, 0);
        for(int i = 0; i < n; i++) {
            System.out.print(getDepth(root, arr[i])+" ");
        }
        return root;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Node root = bst(arr, n);
                System.out.println();
            }
        }
    }
}
