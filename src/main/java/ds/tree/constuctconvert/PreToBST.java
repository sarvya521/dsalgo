package ds.tree.constuctconvert;

public class PreToBST {
	
	class Index {
		int index = 0;
	}
	
	class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	class BST {
		Index index = new Index();
	}

	public static void main(String[] args) {
		int[] pre = new int[] {50, 30, 20, 40, 35, 45, 70, 60, 80};
		int size = pre.length;

	}

}
