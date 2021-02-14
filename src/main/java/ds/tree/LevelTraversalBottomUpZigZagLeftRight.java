package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelTraversalBottomUpZigZagLeftRight {

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    private static void levelTraverse(Node root) {
        StringBuilder builder = new StringBuilder();
        Stack<Node> stack = new Stack();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int s = queue.size();
            while(s != 0) {
                Node n = queue.poll();
                stack.push(n);
                if(n.right != null) {
                    queue.add(n.right);
                }
                if(n.left != null) {
                    queue.add(n.left);
                }
                s--;
            }
            stack.push(null);
        }

        if(null == stack.peek()) {
            stack.pop();
        }

        while (!stack.empty()) {
            Node node = stack.peek();
            if(null == node) {
                builder.append(System.lineSeparator());
            } else {
                builder.append(node.data).append(" ");
            }
            stack.pop();
        }
        System.out.println(builder);
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
                levelTraverse(root);
            }
        }
    }
}
