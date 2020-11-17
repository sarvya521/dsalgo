package ds.tree;

public class Node<E> {
	E data;
	Node<E> left;
	Node<E> right;
	
	Node(E data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data + "";
	}
}
