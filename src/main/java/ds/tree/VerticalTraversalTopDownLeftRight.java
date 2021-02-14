package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class VerticalTraversalTopDownLeftRight {

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    static TreeMap<Integer, TreeSet<Integer>> map;

    private static void traverse(Node root, int v) {
        if(root == null) {
            return;
        }
        final TreeSet<Integer> list = map.getOrDefault(v, new TreeSet<>());
        list.add(root.data);
        map.put(v, list);

        traverse(root.left, v-1);
        traverse(root.right, v+1);
    }

    private static void levelTraverse(Node root) {
        StringBuilder builder = new StringBuilder();

        map = new TreeMap<>();
        traverse(root, 0);

        map.forEach((level, list) -> {
            list.forEach(e -> builder.append(e).append(" "));
            builder.append(System.lineSeparator());
        });

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
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            int t = Integer.parseInt(br.readLine());
//            for(int i = 0; i < t; i++) {
//                int n = Integer.parseInt(br.readLine());
//                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//                Node root = bst(arr, n);
//                levelTraverse(root);
//            }
//        }

        int n = 7;
        int[] arr = Arrays.stream("4 5 15 0 1 7 17".split(" ")).mapToInt(Integer::parseInt).toArray();
        Node root = bst(arr, n);
        levelTraverse(root);
    }
}
