package ds.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyListGraphDemo {
	
	class AdjacencyListGraph {
	    int N;
	    List<List<Integer>> edges;
	    public AdjacencyListGraph(int N) {
	        this.N = N;
	        this.edges = new ArrayList<List<Integer>>();
	        for(int i = 0; i <= N; i++) {
	            edges.add(new LinkedList<Integer>());
	        }
	    }
	}
	
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);
        
        AdjacencyListGraphDemo demo = new AdjacencyListGraphDemo();
        AdjacencyListGraph graph = demo.new AdjacencyListGraph(N);
        int A, B;
        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            A = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);
            graph.edges.get(A).add(B);
            graph.edges.get(B).add(A);
        }
        
        final String YES = "YES";
        final String NO = "NO";
        final int queries = Integer.parseInt(br.readLine());
        for(int i = 0; i < queries; i++) {
            input = br.readLine().split(" ");
            A = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);
            if(graph.edges.get(A).contains(B)) {
                System.out.println(YES);
            } else {
                System.out.println(NO);
            }
        }
    }
}