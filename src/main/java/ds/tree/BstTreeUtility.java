package ds.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BstTreeUtility {
	public static int getHeight(BSTNode node) {
		if (node == null || (node.left == null && node.right == null)) {
			return 0;
		}
		int lh = 0, rh = 0;
		if (node.left != null) {
			lh = getHeight(node.left);
		}
		if (node.right != null) {
			rh = getHeight(node.right);
		}
		return Math.max(lh, rh) + 1;
	}

	public static int maximumDepth(BSTNode root) {
		return getHeight(root);
	}

	public static int getDepth(BSTNode root, BSTNode node) {
		if (node == root) {
			return 0;
		}
		Queue<BSTNode> q = new ArrayDeque<>();
		q.add(root);
		int depth = 0;
		while (!q.isEmpty()) {
			Queue<BSTNode> subq = new ArrayDeque<>();
			while (!q.isEmpty()) {
				BSTNode n = q.poll();
				if (n == node) {
					return depth;
				}
				BSTNode left = n.left;
				BSTNode right = n.right;
				if (left != null) {
					subq.add(left);
				}
				if (right != null) {
					subq.add(right);
				}
			}
			q.addAll(subq);
			depth++;
		}
		return depth;
	}

	public static int getLevel(BSTNode root, BSTNode node) {
		return getDepth(root, node) + 1;
	}
}
