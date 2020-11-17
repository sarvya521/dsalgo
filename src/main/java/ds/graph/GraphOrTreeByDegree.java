package ds.graph;

import java.util.Arrays;
import java.util.stream.Stream;

public class GraphOrTreeByDegree {

	public static final String YES = "YES";
	public static final String NO = "NO";
	
	public static final String GRAPH = "GRAPH";
	public static final String TREE = "TREE";
	
	public static void main(String[] args) {
		int v = 3;
		int[] degrees = new int[] {1, 2, 1};
		solution(v, degrees);
		
		v = 3;
		degrees = new int[] {2, 2, 2};
		solution(v, degrees);
	}

	private static void solution(int v, int[] degrees) {
		long totalSumOfDegrees = Arrays.stream(degrees).sum();
		if(totalSumOfDegrees == 2*(v-1)) {
			System.out.println(TREE);
		} else {
			System.out.println(GRAPH);
		}
	}

}
