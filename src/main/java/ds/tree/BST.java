package ds.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BST<E extends Comparable> {
	
	private BSTNode<E> root;
	
	public BST() {
		root = null;
	}
	
	public void addNode(BSTNode<E> node) {
		if(root == null) {
			root = node;
		} else {
			BSTNode<E> current = root;
			BSTNode<E> parent = null;
			while(true) {
				parent = current;
				if(node.getData().compareTo(current.getData()) > 0) {
					current = current.getRightChild();
					if(current == null) {
						parent.setRightChild(node);
						break;
					}
				} else {
					current = current.getLeftChild();
					if(current == null) {
						parent.setLeftChild(node);
						break;
					}
				}
			}
		}
	}
	
	public BSTNode<E> removeNodeWithData (E data) {
		BSTNode<E> tnode = findNodeWithData(data);
		if(tnode != null) {
			BSTNode<E> parent = getParent(tnode);
			BSTNode<E> left = tnode.getLeftChild();
			BSTNode<E> right = tnode.getRightChild();
			if(left == null && right == null) {
				if(tnode.equals(parent.getRightChild())) {
					parent.setRightChild(null);
				} else {
					parent.setLeftChild(null);
				}
			} else if(right == null) {
				if(tnode.equals(parent.getRightChild())) {
					parent.setRightChild(left);
				} else if(tnode.equals(parent.getLeftChild())) {
					parent.setLeftChild(left);
				}
			} else if(left == null) {
				if(tnode.equals(parent.getRightChild())) {
					parent.setRightChild(right);
				} else if(tnode.equals(parent.getLeftChild())) {
					parent.setLeftChild(right);
				}
			}
			else if(left != null && right != null) {
				BSTNode<E> successor = findSuccessor(right);
				successor.setLeftChild(left);
				successor.setRightChild(right);
				if(tnode.equals(parent.getRightChild())) {
					parent.setRightChild(successor);
				} else if(tnode.equals(parent.getLeftChild())) {
					parent.setLeftChild(successor);
				}
			}
			tnode.setLeftChild(null);
			tnode.setRightChild(null);
		}
		return tnode;
	}
	
	private BSTNode<E> getParent(BSTNode<E> node) {
		return getParent(root, node);
	}
	
	private BSTNode<E> getParent(BSTNode<E> root, BSTNode<E> node) {
		if(root == null || node.equals(root)) {
			return null;
		} else {
			if(node.equals(root.getLeftChild()) || node.equals(root.getRightChild())) {
				return root;
			} else {
				if(root.getData().compareTo(node.getData()) < 0) {
					return getParent(root.getRightChild(), node);
				} else {
					return getParent(root.getLeftChild(), node);
				}
			}
		}
	}
	
	private BSTNode<E> findSuccessor(BSTNode<E> tnode) {
		if(tnode.getLeftChild() != null) {
			return findSuccessor(tnode.getLeftChild());
		} else {
			return findSuccessor(tnode.getRightChild());
		}
	}
	
	public BSTNode<E> findNodeWithData(E data) {
		return binarySearch(root, data);
	}
	
	private BSTNode<E> binarySearch(BSTNode<E> root, E data) {
		if(data.equals(root.getData())) {
			return root;
		} else if(data.compareTo(root.getData()) < 0) {
			return binarySearch(root.getLeftChild(), data);
		} else if(data.compareTo(root.getData()) > 0) {
			return binarySearch(root.getRightChild(), data);
		}
		return null;
	}
	
	private void inOrderTraversal(BSTNode<E> btn, StringBuilder builder) {
		if(btn != null) {
			inOrderTraversal(btn.getLeftChild(), builder);
			builder.append(btn.getData()).append(" ");
			inOrderTraversal(btn.getRightChild(), builder);
		}
	}
	
	private List<List<BSTNode>> levelOrder(BSTNode<E> root) {
        if(root == null) {
            return null;
        }
        List<List<BSTNode>> list = new ArrayList<>();
        Queue<BSTNode> q = new ArrayDeque<>();
        q.add(root);
        List<BSTNode> sublist = new ArrayList<>();
        sublist.add(root);
        list.add(sublist);
        Queue<BSTNode> subq = null;
        BSTNode node = null;
        while(!q.isEmpty()) {
            subq = new ArrayDeque<>();
            sublist = new ArrayList<>();
            while(!q.isEmpty()) {
                node = q.poll();
                if(node.left != null){
                    subq.add(node.left);
                }
                sublist.add(node.left);
                
                if(node.right != null){
                    subq.add(node.right);
                }
                sublist.add(node.right);
            }
            if(sublist.size() > 0) {
                list.add(sublist);    
            }
            q = subq;
        }
        return list;
    }
	
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		inOrderTraversal(root, builder);
		return builder.toString();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {3, 10, 2, 1, 4, 5, 9, 6, 7, 8};
		BST bst = new BST<>();
		for(int i : arr) {
			BSTNode node = new BSTNode<>(i);
			bst.addNode(node);
		}
		
		//TreePrinter.prettyPrint(bst.root, 1, BstTreeUtility.getHeight(bst.root) + 1);
		List<List<BSTNode>> list = bst.levelOrder(bst.root);
		System.out.println(list);
		
		System.out.println("height of tree = height of root = " + BstTreeUtility.getHeight(bst.root));
		System.out.println("max depth of tree = " + BstTreeUtility.maximumDepth(bst.root));
		
		list.stream().forEach(l -> l.stream().filter(e -> e != null).forEach(e -> {
			System.out.println("height of node(" + e + ") = " + BstTreeUtility.getHeight(e) 
			+ " | depth of node(" + e + ") = " + BstTreeUtility.getDepth(bst.root, e)
			+ " | level of node(" + e + ") = " + BstTreeUtility.getLevel(bst.root, e));
		})); 
	}

}
