import java.io.*;
import java.util.*;

public class Solution {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data+"";
        }
    }

    static class BST {
        Node root;

        void addNode(int data) {
            if(root == null) {
                root = new Node(data);
                return;
            }
            Node current = root;
            Node parent = null;
            while(true) {
                parent = current;
                if(data > parent.data) {
                    if(parent.right != null) {
                        current = parent.right;
                    } else {
                        parent.right = new Node(data);
                        break;
                    }
                } else {
                    if(parent.left != null) {
                        current = parent.left;
                    } else {
                        parent.left = new Node(data);
                        break;
                    }
                }
            }
        }
    }

    private static BST createBST(int[] arr) {
        BST bst = new BST();
        for(int i = 0; i < arr.length; i++) {
            bst.addNode(arr[i]);
        }
        return bst;
    }

    private static void process(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            BST bst = createBST(input[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            input = new int[t][];
            for (int i = 0; i < t; i++) {
                br.readLine();
                input[i] = Arrays.stream(br.readLine().split( " ")).mapToInt(Integer::parseInt).toArray();
            }
        }
        process(input);
    }
}