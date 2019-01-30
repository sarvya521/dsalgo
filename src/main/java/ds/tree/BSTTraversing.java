package ds.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BSTTraversing {
	
	static class Node implements Comparable<Node>{
		Integer data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
		
		int getHeight() {
			return getHeight(this);
		}
		
		int getHeight(Node root) {
			if (root == null) {
				return 0;
			}
			return Math.max(getHeight(root.left), getHeight(root.right))+1;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.data.compareTo(n.data);
		}
		
		public String toString() {
			return data+"";
		}
	}
	
	static class BST {
		Node root;
		
		BST() {
			root = null;
		}
		
		void addNode(Node node) {
			if(root == null) {
				root = node;
			} else {
				Node current = root;
				Node parent = null;
				while(true) {
					parent = current;
					if(node.compareTo(current) > 0) {
						current = current.right;
						if(current == null) {
							parent.right = node;
							break;
						}
					} else {
						current = current.left;
						if(current == null) {
							parent.left = node;
							break;
						}
					}
				}
			}
		}
		
		void preOrder(Node root, StringBuilder builder) {
			if(root == null) {
				return;
			}
			builder.append(root).append(" ");
			preOrder(root.left, builder);
			preOrder(root.right, builder);
		}
		
		void inOrder(Node root, StringBuilder builder) {
			if(root == null) {
				return;
			}
			inOrder(root.left, builder);
			builder.append(root).append(" ");
			inOrder(root.right, builder);
		}
		
		void postOrder(Node root, StringBuilder builder) {
			if(root == null) {
				return;
			}
			postOrder(root.left, builder);
			postOrder(root.right, builder);
			builder.append(root).append(" ");
		}
		
		int countChildren(Node root) {
			if(root == null) {
				return 0;
			}
			return 1+countChildren(root.left)+countChildren(root.right);
		}
		
		void getAllNodesChildren(Node root) {
			if(root == null) {
				return;
			}
			System.out.println("Node="+root+" - children="+(countChildren(root)-1));
			getAllNodesChildren(root.left);
			getAllNodesChildren(root.right);
		}
		
		void getAllNodesDepth(Node root) {
			if(root == null) {
				return;
			}
			System.out.println("Node="+root+" - depth="+(getDepth(this.root, root, 0)));
			getAllNodesDepth(root.left);
			getAllNodesDepth(root.right);
		}
		
		int getDepth(Node root, Node node, int depth) {
			if(root == null) {
				return 0;
			}
			if(root.equals(node)) {
				return depth;
			}
			depth++;
			return getDepth(root.left, node, depth)+getDepth(root.right, node, depth);
		}
	}
	
	private static void solve(int[] arr) {
		int n = arr.length;
		BST bst = new BST();
		for(int i = 0; i < n; i++) {
			Node node = new Node(arr[i]);
			bst.addNode(node);
		}
		StringBuilder pre = new StringBuilder();
		bst.preOrder(bst.root, pre);
		StringBuilder in = new StringBuilder();
		bst.inOrder(bst.root, in);
		StringBuilder post = new StringBuilder();
		bst.postOrder(bst.root, post);
		System.out.println(pre+"\n"+in+"\n"+post);
		System.out.println("\n");
		System.out.println("root-height="+(bst.root.getHeight()-1));
		System.out.println("\n");
		bst.getAllNodesChildren(bst.root);
		System.out.println("\n");
		bst.getAllNodesDepth(bst.root);
	}
	
	private static void solve(String[] queries, int t) {
		int[] arr = null;
		for(String query : queries) {
			arr = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
			solve(arr);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		String[] queries = new String[t];
		for(int i = 0; i < t; i++) {
			input.readLine();
			queries[i] = input.readLine().trim();
		}
		input.close();
		solve(queries, t);
	}

}
