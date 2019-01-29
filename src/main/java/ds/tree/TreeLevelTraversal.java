package tree;

import java.util.*;

public class TreeLevelTraversal {
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        List<Integer> sublist = new ArrayList<>();
        sublist.add(root.val);
        list.add(sublist);
        Queue<TreeNode> subq = null;
        TreeNode node = null;
        while(!q.isEmpty()) {
            subq = new ArrayDeque<>();
            sublist = new ArrayList<>();
            while(!q.isEmpty()) {
                node = q.poll();
                if(node.left != null){
                    subq.add(node.left);
                    sublist.add(node.left.val);
                }
                if(node.right != null){
                    subq.add(node.right);
                    sublist.add(node.right.val);
                }
            }
            if(sublist.size() > 0) {
                list.add(sublist);    
            }
            q = subq;
        }
        return list;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(levelOrder(root));
	}

}