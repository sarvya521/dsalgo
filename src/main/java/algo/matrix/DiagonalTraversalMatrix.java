package algo.matrix;

import java.util.Scanner;

public class DiagonalTraversalMatrix {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
            int[] sums = new int[(n*2)-1];
		    int mid = ((n*2)-1)/2;
		    int index = 0;
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					int e = in.nextInt();
                    if(r == c) {
                        sums[mid] += e;
                        continue;
                    } else if (c > r) {
                        index = mid - (c - r);
                        sums[index] += e;
                    } else {
                        index = mid + (r - c);
                        sums[index] += e;
                    }
				}
			}
            for(int k = 0; k < sums.length; k++) {
			     System.out.print(sums[k]+" ");
		    }
            System.out.println();
		}
		in.close();
	}
}
