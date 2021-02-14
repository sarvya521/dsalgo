package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

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

    private static boolean isCBT(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(n.left != null) {
                if(flag) {
                    return false;
                }
                queue.add(n.left);
            } else {
                flag = true;
            }
            if(n.right != null) {
                if(flag) {
                    return false;
                }
                queue.add(n.right);
            } else {
                flag = true;
            }
        }
        return true;
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

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Node root = bst(arr, n);
                System.out.println(isCBT(root) ? "True" : "False");
            }
        }
    }
}
