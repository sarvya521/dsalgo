package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodesAtDistanceK {

    static int s;
    static Node S;

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
            Node n = new Node(x);
            if(x == s) {
                S = n;
            }
            return n;
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

    private static int count(Node root, int d) {
        if(root == null || d < 0) {
            return 0;
        }
        if(d == 0) {
            return 1;
        }
        return count(root.left, d-1) + count(root.right, d-1);
    }

    private static void path(Node root, Node s, List<Node> list) {
        if(root == null) {
            return;
        }
        if(root == s) {
            list.add(s);
            return;
        }
        path(root.left, s, list);
        if(!list.isEmpty()) {
            list.add(root);
            return;
        }
        path(root.right, s, list);
        if(!list.isEmpty()) {
            list.add(root);
            return;
        }
    }

    private static void solve(int[] arr, int n, int k) {
        Node root = bst(arr, n);
        List<Node> list = new ArrayList<>();
        path(root, S, list);
        int ans = count(S, k);
        if(list.size() > k) {
            ans = ans + 1;
        }
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i).left == list.get(i-1)) {
                ans = ans + count(list.get(i).right, k-i-1);
            } else {
                ans = ans + count(list.get(i).left, k-i-1);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                int[] ip = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                s = ip[1];
                solve(arr, ip[0], ip[2]);
            }
        }
//        int[] ip = new int[]{5, 3, 2};
//        int[] arr = new int[]{1, 2, 3, 4, 5};
//        s = ip[1];
//        solve(arr, ip[0], ip[2]);
    }
}
