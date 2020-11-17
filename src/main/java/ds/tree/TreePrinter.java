package ds.tree;

import java.util.Scanner;

public class TreePrinter {

	/*
	 * @param root Root node of a tree
	 * 
	 * @param currentHeight current height of node. initial value is always 1
	 * 
	 * @param totalHeight height of tree + 1
	 * 
	 * @return String showing tree diagram
	 */
	public static void prettyPrint(Node root, int currentHeight, int totalHeight) {
		System.out.println(draw(root, currentHeight, totalHeight));
	}
	
	private static StringBuilder draw(Node root, int currentHeight, int totalHeight) {
		StringBuilder sb = new StringBuilder();
		int spaces = getSpaceCount(totalHeight - currentHeight + 1);
		if (root == null) {
			// create a 'spatial' block and return it
			String row = String.format("%" + (2 * spaces + 1) + "s%n", "");
			// now repeat this row space+1 times
			String block = new String(new char[spaces + 1]).replace("\0", row);
			return new StringBuilder(block);
		}
		if (currentHeight == totalHeight)
			return new StringBuilder(root.data + "");
		int slashes = getSlashCount(totalHeight - currentHeight + 1);
		sb.append(String.format("%" + (spaces + 1) + "s%" + spaces + "s", root.data + "", ""));
		sb.append("\n");
		// now print / and \
		// but make sure that left and right exists
		char leftSlash = root.left == null ? ' ' : '/';
		char rightSlash = root.right == null ? ' ' : '\\';
		int spaceInBetween = 1;
		for (int i = 0, space = spaces - 1; i < slashes; i++, space--, spaceInBetween += 2) {
			for (int j = 0; j < space; j++)
				sb.append(" ");
			sb.append(leftSlash);
			for (int j = 0; j < spaceInBetween; j++)
				sb.append(" ");
			sb.append(rightSlash + "");
			for (int j = 0; j < space; j++)
				sb.append(" ");
			sb.append("\n");
		}
		// sb.append("\n");

		// now get string representations of left and right subtrees
		StringBuilder leftTree = draw(root.left, currentHeight + 1, totalHeight);
		StringBuilder rightTree = draw(root.right, currentHeight + 1, totalHeight);
		// now line by line print the trees side by side
		Scanner leftScanner = new Scanner(leftTree.toString());
		Scanner rightScanner = new Scanner(rightTree.toString());
		// spaceInBetween+=1;
		while (leftScanner.hasNextLine()) {
			if (currentHeight == totalHeight - 1) {
				sb.append(String.format("%-2s %2s", leftScanner.nextLine(), rightScanner.nextLine()));
				sb.append("\n");
				spaceInBetween -= 2;
			} else {
				sb.append(leftScanner.nextLine());
				sb.append(" ");
				sb.append(rightScanner.nextLine() + "\n");
			}
		}
		leftScanner.close();
		rightScanner.close();

		return sb;
	}

	private static int getSlashCount(int height) {
		if (height <= 3) {
			return height - 1;
		}
		return (int) (3 * Math.pow(2, height - 3) - 1);
	}

	private static int getSpaceCount(int height) {
		return (int) (3 * Math.pow(2, height - 2) - 1);
	}
	
	/*
	 * @param root Root node of a tree
	 * 
	 * @param currentHeight current height of node. initial value is always 1
	 * 
	 * @param totalHeight height of tree + 1
	 * 
	 * @return String showing tree diagram
	 */
	public static void prettyPrint(BSTNode root, int currentHeight, int totalHeight) {
		System.out.println(draw(root, currentHeight, totalHeight));
	}
	
	private static StringBuilder draw(BSTNode root, int currentHeight, int totalHeight) {
		StringBuilder sb = new StringBuilder();
		int spaces = getSpaceCount(totalHeight - currentHeight + 1);
		if (root == null) {
			// create a 'spatial' block and return it
			String row = String.format("%" + (2 * spaces + 1) + "s%n", "");
			// now repeat this row space+1 times
			String block = new String(new char[spaces + 1]).replace("\0", row);
			return new StringBuilder(block);
		}
		if (currentHeight == totalHeight)
			return new StringBuilder(root.data + "");
		int slashes = getSlashCount(totalHeight - currentHeight + 1);
		sb.append(String.format("%" + (spaces + 1) + "s%" + spaces + "s", root.data + "", ""));
		sb.append("\n");
		// now print / and \
		// but make sure that left and right exists
		char leftSlash = root.left == null ? ' ' : '/';
		char rightSlash = root.right == null ? ' ' : '\\';
		int spaceInBetween = 1;
		for (int i = 0, space = spaces - 1; i < slashes; i++, space--, spaceInBetween += 2) {
			for (int j = 0; j < space; j++)
				sb.append(" ");
			sb.append(leftSlash);
			for (int j = 0; j < spaceInBetween; j++)
				sb.append(" ");
			sb.append(rightSlash + "");
			for (int j = 0; j < space; j++)
				sb.append(" ");
			sb.append("\n");
		}
		// sb.append("\n");

		// now get string representations of left and right subtrees
		StringBuilder leftTree = draw(root.left, currentHeight + 1, totalHeight);
		StringBuilder rightTree = draw(root.right, currentHeight + 1, totalHeight);
		// now line by line print the trees side by side
		Scanner leftScanner = new Scanner(leftTree.toString());
		Scanner rightScanner = new Scanner(rightTree.toString());
		// spaceInBetween+=1;
		while (leftScanner.hasNextLine()) {
			if (currentHeight == totalHeight - 1) {
				sb.append(String.format("%-2s %2s", leftScanner.nextLine(), rightScanner.nextLine()));
				sb.append("\n");
				spaceInBetween -= 2;
			} else {
				sb.append(leftScanner.nextLine());
				sb.append(" ");
				sb.append(rightScanner.nextLine() + "\n");
			}
		}
		leftScanner.close();
		rightScanner.close();

		return sb;
	}
}
