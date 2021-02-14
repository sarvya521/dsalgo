import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Integer.*;
import static java.lang.Math.PI;

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

    /*public static void main(String[] args) throws Exception {
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
    }*/

    private static int solve(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            Integer count = map.getOrDefault(arr[i], 0);
            map.put(arr[i], count+1);
        }
        final ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                final int ans = e2.getValue().compareTo(e1.getValue());
                if(ans == 0) {
                    return e1.getKey().compareTo(e2.getKey());
                }
                return ans;
            }
        });
        return entries.get(0).getKey();
    }

    private static double solve(int x1, int y1, int x2, int y2, int x3, int y3) {
        final double d1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        final double d2 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y3 - y1, 2));
        final double d3 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        return (d1+d2+d3)/3;
    }

    /*private static int solve(int[] arr, int n) {
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == n) {
                count++;
            }
        }
        final Integer integer = new Integer(3);
        return count;
    }*/

    public static void main(String[] args) {
        Integer a = 1;
        System.out.println(a++ + ++a);
        char b = 'a';
        long c = 2l;
        System.out.println(PI);
    }
}

class ABCD {
    public final static int MAX_VALUE = 100;
}