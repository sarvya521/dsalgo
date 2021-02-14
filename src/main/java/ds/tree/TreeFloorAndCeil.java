package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class TreeFloorAndCeil {

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

        int x = arr[new Random().nextInt(n)];
        int f = x + 1;
        System.out.println("floor("+f+"): "+floor(root, Integer.MIN_VALUE, f));
        int c = x - 1;
        System.out.println("ceil("+c+"): "+ceil(root, Integer.MAX_VALUE, c));
    }

    private static int floor(Node root, int a, int x) {
        if(root == null) {
            return a;
        }
        if(root.data == x) {
            return root.data;
        }
        if(root.left == null && root.right == null) {
            if(root.data > x) {
                return a;
            } else {
                return root.data;
            }
        }
        if(root.data < x) {
            return Math.max(a, floor(root.right, root.data, x));
        } else {
            return Math.max(a, floor(root.left, a, x));
        }
    }

    private static int ceil(Node root, int a, int x) {
        if(root == null) {
            return a;
        }
        if(root.data == x) {
            return root.data;
        }
        if(root.left == null && root.right == null) {
            if(root.data < x) {
                return a;
            } else {
                return root.data;
            }
        }
        if(root.data < x) {
            return Math.min(a, ceil(root.right, a, x));
        } else {
            return Math.min(a, ceil(root.left, root.data, x));
        }
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
