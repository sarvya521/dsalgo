package tree;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SmallerElements_SelfBalancingBinarySearchTree {

	class SBBSTNodes {
		SBBSTNodes left, right;
		long data;
		long height;
		long height2;
		long size;

		public SBBSTNodes() {
			left = null;
			right = null;
			data = 0;
			height = 0;
			size = 0;
		}

		public SBBSTNodes(long n) {
			left = null;
			right = null;
			data = n;
			height = 1;
			size = 1;
		}
		
		public String toString() {
			return data+"";
		}
	}
    
	private SBBSTNodes root;
	
	public SmallerElements_SelfBalancingBinarySearchTree() {
		root = null;
	}

	private long height(SBBSTNodes t) {
		return t == null ? 0 : t.height;
	}
	
	private long height2(SBBSTNodes t) {
		return t == null ? 0 : t.height2;
	}
	
	private long size(SBBSTNodes t) {
		return t == null ? 0 : t.size;
	}

	private long max(long lhs, long rhs) {
		return lhs > rhs ? lhs : rhs;
	}
	
	private SBBSTNodes rightRotate(SBBSTNodes y) {
		SBBSTNodes x = y.left;
		SBBSTNodes z = x.right;
		x.right = y;
		y.left = z;
		
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), x.height) + 1;
		
		y.size = size(y.left) + size(y.right) + 1;
	    x.size = size(x.left) + size(x.right) + 1;
	    
		return x;
	}

	private SBBSTNodes leftRotate(SBBSTNodes x) {
		SBBSTNodes y = x.right;
		SBBSTNodes z = y.left;
		y.left = x;
		x.right = z;
		
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		
		x.size = size(x.left) + size(x.right) + 1;
		y.size = size(y.left) + size(y.right) + 1;
	    
		return y;
	}
	
	private long getBalance(SBBSTNodes n) {
		if (n == null)
			return 0;
		return height(n.left) - height(n.right);
	}
	
	public boolean search(long val) {
        return search(root, val);
    }
    private boolean search(SBBSTNodes r, long val)
    {
		boolean found = false;
		while ((r != null) && !found) {
			long rval = r.data;
			if (val < rval) {
				r = r.left;
			} else if (val > rval) {
				r = r.right;
			} else {
				found = true;
				break;
			}
			found = search(r, val);
		}
		return found;
    }
	
	private SBBSTNodes insert(SBBSTNodes t, int data, long[] countList, int index) {
		if (t == null) {
			t = new SBBSTNodes(data);
		} else if (data <= t.data) {
			t.left = insert(t.left, data, countList, index);
		} else if (data > t.data) {
			t.right = insert(t.right, data, countList, index);
			countList[index] = countList[index] + size(t.left) + 1;
		}
		t.height = max(height(t.left), height(t.right));
		t.height2 = max(height2(t.left), height2(t.right)) + 1;
		t.size = size(t.left) + size(t.right) + 1;
		
		long balance = getBalance(t);
		if (balance > 1 && data < t.left.data)
	        return rightRotate(t);
		if (balance < -1 && data > t.right.data)
	        return leftRotate(t);
		if (balance > 1 && data > t.left.data) {
			t.left =  leftRotate(t.left);
	        return rightRotate(t);
	    }
		if (balance < -1 && data < t.right.data) {
			t.right = rightRotate(t.right);
	        return leftRotate(t);
	    }
		return t;
	}
	
	public void printTree() {
		printTree(root);
	}
	
	public void printTree(SBBSTNodes root) {
		if(root == null) {
			return;
		}
		System.out.println(root.left+"\t"+root+"\t"+root.right);
		printTree(root.left);
		printTree(root.right);
	}
	private long getSlashCount(long height) {
		if(height <= 3) return height -1;
		return (long) (3*Math.pow(2, height-3)-1);
	}
	private long getSpaceCount(long height) {
		return (long) (3*Math.pow(2, height-2)-1);
	}
	public void prettyPrint() {
		System.out.println(prettyPrint(root, 1, root.height2));
	}
	private StringBuilder prettyPrint(SBBSTNodes root, long currentHeight, long totalHeight) {
		StringBuilder sb = new StringBuilder();
		int spaces = (int)getSpaceCount(totalHeight-currentHeight + 1);
		if(root == null) {
			//create a 'spatial' block and return it
			String row = String.format("%"+(2*spaces+1)+"s%n", "");
			//now repeat this row space+1 times
			String block = new String(new char[spaces+1]).replace("\0", row);
			return new StringBuilder(block);
		}
		if(currentHeight==totalHeight) return new StringBuilder(root.data+"");
		long slashes = getSlashCount(totalHeight-currentHeight +1);
		sb.append(String.format("%"+(spaces+1)+"s%"+spaces+"s", root.data+"", ""));
		sb.append("\n");
		//now print / and \
		// but make sure that left and right exists
		char leftSlash = root.left == null? ' ':'/';
		char rightSlash = root.right==null? ' ':'\\';
		int spaceInBetween = 1;
		for(int i=0, space = spaces-1; i<slashes; i++, space --, spaceInBetween+=2) {
			for(int j=0; j<space; j++) sb.append(" ");
			sb.append(leftSlash);
			for(int j=0; j<spaceInBetween; j++) sb.append(" ");
			sb.append(rightSlash+"");
			for(int j=0; j<space; j++) sb.append(" ");
			sb.append("\n");
		}
		//sb.append("\n");

		//now get string representations of left and right subtrees
		StringBuilder leftTree = prettyPrint(root.left, currentHeight+1, totalHeight);
		StringBuilder rightTree = prettyPrint(root.right, currentHeight+1, totalHeight);
		// now line by line print the trees side by side
		Scanner leftScanner = new Scanner(leftTree.toString());
		Scanner rightScanner = new Scanner(rightTree.toString());
//		spaceInBetween+=1;
		while(leftScanner.hasNextLine()) {
			if(currentHeight==totalHeight-1) {
				sb.append(String.format("%-2s %2s", leftScanner.nextLine(), rightScanner.nextLine()));
				sb.append("\n");
				spaceInBetween-=2;				
			}
			else {
				sb.append(leftScanner.nextLine());
				sb.append(" ");
				sb.append(rightScanner.nextLine()+"\n");
			}
		}
		return sb;
	}
	
	public int countNodes() {
		return countNodes(root);
	}

	private int countNodes(SBBSTNodes r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.left);
			l += countNodes(r.right);
			return l;
		}
	}
	
	private void solve(int[] arr) {
		root = null;
		int n = arr.length;
        long[] a = new long[n];
        for (int j = n - 1; j >= 0; j--) {
        	root = insert(root, arr[j], a, j);
            prettyPrint();
        }
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
        System.out.println(LongStream.of(a).sum());
        //prettyPrint();
	}
    
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int t = in.nextInt();
		for(int i = 0; i < t; i++) {
            Solution sbbst = new Solution();
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
            long[] a = new long[n];
            List<Long> countList = Arrays.stream(a).boxed().collect(Collectors.toList());
            for (int k = n - 1; k >= 0; k--) {
                sbbst.insert(arr[k], countList, k);
            }
            System.out.println(countList.stream().mapToLong(Long::longValue).sum());
        }*/
    	SmallerElements_SelfBalancingBinarySearchTree sbbst = new SmallerElements_SelfBalancingBinarySearchTree();
    	/*int n = 6;
    	int[] arr = new int[n];
        int k = -1;
        for(int s = 0; s < 3; s++) {
        	arr[s] = k--;
        }
        k = -1;
        for(int s = 3; s < n; s++) {
        	arr[s] = k--;
        }*/
    	
    	int[] arr = new int[]{15, 35, 25, 10, 15, 12};
    	sbbst.solve(arr);
    	/*int n = arr.length;
        long[] a = new long[n];
        for (int j = n - 1; j >= 0; j--) {
            sbbst.insert(arr[j], a, j);
            //sbbst.prettyPrint();
        }
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
        System.out.println(LongStream.of(a).sum());
        sbbst.prettyPrint();*/
    }
}
