package algo.recursion;

import java.util.Scanner;

public class TowersOfHanoiGUI {
	
	public static StringBuilder toh(int n, char src, char dest, char tmp, StringBuilder builder) {
		if(n == 0) {
			return builder;
		}
		toh(n - 1, src, tmp, dest, builder);
		builder.append("Move "+n+" from "+src+" to "+dest).append("\n");
		toh(n - 1, tmp, dest, src, builder);
		return builder;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int n = in.nextInt();
			StringBuilder builder = new StringBuilder();
			builder = toh(n, 'A', 'C', 'B', builder);
			String moves = builder.toString().trim();
			System.out.println(moves.split("\n").length);
			System.out.println(moves);
		}
		in.close();
	}

}
