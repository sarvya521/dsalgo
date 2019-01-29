package tree;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinaryTreeNode<E extends Comparable> {
	
	public E data;
	
	public BinaryTreeNode<E> left;
	
	public BinaryTreeNode<E> right;
	
	public long height;
	
	public BinaryTreeNode() {
		this.left = null;
		this.right = null;
	}
	
	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BinaryTreeNode<E> getLeftChild() {
		return this.left;
	}
	
	public void setLeftChild (BinaryTreeNode<E> left) {
		this.left = left;
	}
	
	public BinaryTreeNode<E> getRightChild() {
		return this.right;
	}
	
	public void setRightChild(BinaryTreeNode<E> right) {
		this.right = right;
	}
	
	public void write(ObjectOutputStream oos) {
		try {
			E data = getData();
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(left != null) {
			left.write(oos);
		}
		if(right != null) {
			right.write(oos);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryTreeNode other = (BinaryTreeNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [data=" + data + "]";
	}
}
