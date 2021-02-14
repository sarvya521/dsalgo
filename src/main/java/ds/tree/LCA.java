package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LCA {

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

    static Node lca(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data > n1 && node.data > n2) {
            return lca(node.left, n1, n2);
        }

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data < n1 && node.data < n2) {
            return lca(node.right, n1, n2);
        }

        return node;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                int[] ip = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int N = ip[0];
                int Q = ip[1];
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                final Node root = bst(arr, N);
                for(int j = 0; j < Q; j++) {
                    int[] queries = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    System.out.print(lca(root, queries[0], queries[1])+" ");
                }
                System.out.println();
            }
        }
    }
}
