package ds.tree;

public class BSTNode<E extends Comparable> {
	
	public E data;
	
	public BSTNode<E> left;
	
	public BSTNode<E> right;
	
	public BSTNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BSTNode<E> getLeftChild() {
		return this.left;
	}
	
	public void setLeftChild (BSTNode<E> left) {
		this.left = left;
	}
	
	public BSTNode<E> getRightChild() {
		return this.right;
	}
	
	public void setRightChild(BSTNode<E> right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return this.data + "";
	}
}
