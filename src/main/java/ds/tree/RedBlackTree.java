package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RedBlackTree {
	
	private static final boolean BLACK = true;
	private static final boolean RED = false;
	
	static Node root;
	
	private static class Node {
		int data;
		Node left;
		Node right;
		Node parent;
		boolean color = BLACK;
		
		Node(int data, Node parent) {
			this.data = data;
			this.parent = parent;
		}

		@Override
		public String toString() {
			return data + " " + (color ? "B" : "R");
		}
	}
	
	private static class NodeMinMaxHeight {
		int min;
		int max;
		
		NodeMinMaxHeight() {}
		
		NodeMinMaxHeight(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}
	
	private static boolean isBalanced(Node root, NodeMinMaxHeight minMaxH) {
		if(root == null) {
			minMaxH.max = minMaxH.min = 0;
			return true;
		}
		NodeMinMaxHeight leftH = new NodeMinMaxHeight(0, 0);
		NodeMinMaxHeight rightH = new NodeMinMaxHeight(0, 0);
		if(isBalanced(root.left, leftH) == false) {
			return false;
		}
		if(isBalanced(root.right, rightH) == false) {
			return false;
		}
		
		minMaxH.max = Math.max(leftH.max, rightH.max) + 1;
		minMaxH.min = Math.max(leftH.min, rightH.min) + 1;
		
		if(minMaxH.max <= 2*minMaxH.min) {
			return true;
		}
		
		return false;
	}
	
	private static List<List<Node>> levelOrderWithDetails(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Node>> list = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        List<Node> sublist = new ArrayList<>();
        sublist.add(root);
        list.add(sublist);
        Queue<Node> subq = null;
        Node node = null;
        while(!q.isEmpty()) {
            subq = new ArrayDeque<>();
            sublist = new ArrayList<>();
            while(!q.isEmpty()) {
                node = q.poll();
                if(node.left != null){
                    subq.add(node.left);
                    sublist.add(node.left);
                } else {
                	sublist.add(null);
                }
                if(node.right != null){
                    subq.add(node.right);
                    sublist.add(node.right);
                } else {
                	sublist.add(null);
                }
            }
            if(sublist.size() > 0) {
                list.add(sublist);    
            }
            q = subq;
        }
        return list;
    }
	
	private static Node parentOf(Node node) {
		return (node == null ? null : node.parent);
	}
	
	private static Node leftOf(Node node) {
		return (node == null ? null : node.left);
	}
	
	private static Node rightOf(Node node) {
		return (node == null ? null : node.right);
	}
	
	private static boolean colorOf(Node node) {
		return (node == null ? BLACK : node.color);
	}
	
	private static void setColor(Node node, boolean color) {
		node.color = color;
	}
	
	private static void rotateRight(Node node) {
		if(node != null) {
			Node l = node.left;
			node.left = l.right;
			if(l.right != null) {
				l.right.parent = node;
			}
			l.parent = node.parent;
			if(node.parent == null) {
				root = l;
			} else if(node.parent.left == node) {
				node.parent.left = l;
			} else {
				node.parent.right = l;
			}
			l.right = node;
			node.parent = l;
		}
	}
	
	private static void rotateLeft(Node node) {
		if(node != null) {
			Node r = node.right;
			node.right = r.left;
			if(r.left != null) {
				r.left.parent = node;
			}
			r.parent = node.parent;
			if(node.parent == null) {
				root = r;
			} else if(node.parent.left == node) {
				node.parent.left = r;
			} else {
				node.parent.right = r;
			}
			r.left = node;
			node.parent = r;
		}
	}
	
	private static void fixAfterInsertion(Node x) {
		x.color = RED;
		while(x != null && x != root && x.parent.color == RED) { // parent is RED
			if(parentOf(x) == leftOf(parentOf(parentOf(x)))) { // parent is left child of grandparent
				Node y = rightOf(parentOf(parentOf(x)));
				if(colorOf(y) == RED) { // both parent and uncle are RED, then drag blackness from grandparent 
										// and make grandparent RED
					setColor(parentOf(x), BLACK);
					setColor(y, BLACK);
					setColor(parentOf(parentOf(x)), RED);
					x = parentOf(parentOf(x)); // after making grandparent RED, 
											   // check RED-RED combination recursively in upper subtree
				} else { // uncle is not RED, so we have to do rotation
					if(x == rightOf(parentOf(x))) { // node is right child of parent so RL => LR
						x = parentOf(x);
						rotateLeft(x);
					}
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					rotateRight(parentOf(parentOf(x))); // node is left child of parent so LL => R
				}
			} else { // parent is right child of grandparent
				Node y = leftOf(parentOf(parentOf(x)));
				if(colorOf(y) == RED) { // both parent and uncle are RED, then drag blackness from grandparent
										// and make grandparent RED
					setColor(parentOf(x), BLACK);
					setColor(y, BLACK);
					setColor(parentOf(parentOf(x)), RED);
					x = parentOf(parentOf(x));  // after making grandparent RED, 
					   							// check RED-RED combination recursively in upper subtree
				} else { // uncle is not RED, so we have to do rotation
					if(x == leftOf(parentOf(x))) { // node is left child of parent so LR => RL
						x = parentOf(x);
						rotateRight(x);
					}
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					rotateLeft(parentOf(parentOf(x))); // node is right child of parent so RR => L
				}
			}
		}
		root.color = BLACK;
	}
	
	private static void insert(int data) {
		Node node = root;
		if(node == null) {
			root = new Node(data, null);
			return;
		}
		Node parent;
		do {
			parent = node;
			if(data < node.data) {
				node = node.left;
			} else if(data > node.data) {
				node = node.right;
			} else {
				return; // same data node
			}
		} while(node != null);
		Node newNode = new Node(data, parent);
		if(data < parent.data) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		fixAfterInsertion(newNode);
	}

	public static void main(String[] args) throws Exception {
		int[] arr = new int[] {17, 16, 10, 9, 8, 4, 13, 11, 5, 6};
		for(int data : arr) {
			try {
				insert(data);
			} catch(Exception e) {
				throw new Exception("exception while inserting "+data, e);
			}
		}
		System.out.println(levelOrderWithDetails(root));
		System.out.println(isBalanced(root, new NodeMinMaxHeight(0, 0)));
	}

}
