package tree;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BinaryTree<E extends Comparable> {
	
	private BinaryTreeNode<E> root;
	
	public BinaryTree() {
		root = null;
	}
	
	public void addNode(BinaryTreeNode<E> node) {
		if(root == null) {
			root = node;
		} else {
			BinaryTreeNode<E> current = root;
			BinaryTreeNode<E> parent = null;
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
	
	public BinaryTreeNode<E> removeNodeWithData (E data) {
		BinaryTreeNode<E> tnode = findNodeWithData(data);
		if(tnode != null) {
			BinaryTreeNode<E> parent = getParent(tnode);
			BinaryTreeNode<E> left = tnode.getLeftChild();
			BinaryTreeNode<E> right = tnode.getRightChild();
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
				BinaryTreeNode<E> successor = findSuccessor(right);
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
	
	private BinaryTreeNode<E> getParent(BinaryTreeNode<E> node) {
		return getParent(root, node);
	}
	
	private BinaryTreeNode<E> getParent(BinaryTreeNode<E> root, BinaryTreeNode<E> node) {
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
	
	private BinaryTreeNode<E> findSuccessor(BinaryTreeNode<E> tnode) {
		if(tnode.getLeftChild() != null) {
			return findSuccessor(tnode.getLeftChild());
		} else {
			return findSuccessor(tnode.getRightChild());
		}
	}
	
	public BinaryTreeNode<E> findNodeWithData(E data) {
		return binarySearch(root, data);
	}
	
	private BinaryTreeNode<E> binarySearch(BinaryTreeNode<E> root, E data) {
		if(data.equals(root.getData())) {
			return root;
		} else if(data.compareTo(root.getData()) < 0) {
			return binarySearch(root.getLeftChild(), data);
		} else if(data.compareTo(root.getData()) > 0) {
			return binarySearch(root.getRightChild(), data);
		}
		return null;
	}
	
	public void write(ObjectOutputStream oos) {
		if (root != null) {
			root.write(oos);
		}
	}
	
	public void read(ObjectInputStream ois) {
		root = new BinaryTreeNode<E>();
		read(root, ois);
	}
	
	public BinaryTreeNode<E> read(BinaryTreeNode<E> node, ObjectInputStream ois) {
		try {
			Object obj = ois.readObject();
			if(obj != null) {
				E data = (E)obj;
				if(node == null) {
					node = new BinaryTreeNode<E>();
				}
				node.setData(data);
				
				BinaryTreeNode<E> left = read(node.getLeftChild(), ois);
				BinaryTreeNode<E> right = read(node.getRightChild(), ois);
				
				node.setLeftChild(left);
				node.setRightChild(right);
			}
		} catch (EOFException ex) {
		    System.out.println("End of file reached.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return node;
	}

	public void read(Object obj) {
		if(obj != null) {
			E data = (E)obj;
			BinaryTreeNode<E> node = new BinaryTreeNode<E>();
			node.setData(data);
			addNode(node);
		}
	}
	
	public void printTreeDiagram() {
		
	}
	
	private void inOrderTraversal(BinaryTreeNode<E> btn, StringBuilder builder) {
		if(btn != null) {
			inOrderTraversal(btn.getLeftChild(), builder);
			//System.out.print(btn.getData()+ " ");
			builder.append(btn.getData()).append(" ");
			inOrderTraversal(btn.getRightChild(), builder);
		}
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		inOrderTraversal(root, builder);
		return builder.toString();
	}

}
