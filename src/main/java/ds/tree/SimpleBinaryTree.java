package ds.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SimpleBinaryTree {

	Node root;

	SimpleBinaryTree() {
		root = null;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 2, 3, 4, 5 };
		int size = arr.length;

		SimpleBinaryTree tree = new SimpleBinaryTree();
		
		tree.root = new Node(arr[0]);
		
		List<Node> list = new ArrayList<>();
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(tree.root);
		list.add(tree.root);
		for (int i = 1; i < size; i = i + 2) {
			Node current = q.poll();
			
			current.left = new Node(arr[i]);
			q.add(current.left);
			
			list.add(current.left);
			
			if (i + 1 < size) {
				current.right = new Node(arr[i + 1]);
				q.add(current.right);
				
				list.add(current.right);
			}
		}
		
		TreePrinter.prettyPrint(tree.root, 1, TreeUtility.getHeight(tree.root) + 1);
		
		System.out.println("height of tree = height of root = " + TreeUtility.getHeight(tree.root));
		System.out.println("max depth of tree = " + TreeUtility.maximumDepth(tree.root));
		
		list.stream().forEach(e -> {
			System.out.println("height of node(" + e + ") = " + TreeUtility.getHeight(e) 
					+ " | depth of node(" + e + ") = " + TreeUtility.getDepth(tree.root, e)
					+ " | level of node(" + e + ") = " + TreeUtility.getLevel(tree.root, e));
		});
		
	}

}
