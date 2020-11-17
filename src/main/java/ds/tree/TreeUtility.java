package ds.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeUtility {
	public static int getHeight(Node node) {
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

	public static int maximumDepth(Node root) {
		return getHeight(root);
	}

	public static int getDepth(Node root, Node node) {
		if (node == root) {
			return 0;
		}
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		int depth = 0;
		while (!q.isEmpty()) {
			Queue<Node> subq = new ArrayDeque<>();
			while (!q.isEmpty()) {
				Node n = q.poll();
				if (n == node) {
					return depth;
				}
				Node left = n.left;
				Node right = n.right;
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

	public static int getLevel(Node root, Node node) {
		return getDepth(root, node) + 1;
	}
}
