package ds.trie;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contacts {

    private static final String ADD = "add";
    private static final String FIND = "find";

    static class Node {
        int cnt;
        Node c[];
        Node() {
            c = new Node[26];
        }
    }

    private static void add(Node root, String word) {
        char[] charr = word.toCharArray();
        for(int i = 0; i < charr.length; i++) {
            int idx = charr[i] - 'a';
            if(root.c[idx] == null) {
                root.c[idx] = new Node();
            }
            root = root.c[idx];
            root.cnt++;
        }
    }

    private static int find(Node root, String query) {
        final char[] charr = query.toCharArray();
        for(int i = 0; i < charr.length; i++) {
            int idx = charr[i] - 'a';
            if(root.c[idx] == null) {
                return 0;
            }
            root = root.c[idx];
        }
        return root.cnt;
    }

    public static void main(String[] args) throws Exception {
        Node root = new Node();
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                final String[] arr = br.readLine().split(" ");
                if (ADD.equals(arr[0])) {
                    add(root, arr[1]);
                } else {
                    builder.append(find(root, arr[1])).append(System.lineSeparator());
                }
            }
            System.out.println(builder);
        }
    }
}
