package ds.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TwoWayAttack {

	class Graph {
		int n;
		List<List<Integer>> adjacencyList;
		
		Graph(int n) {
			this.n= n+1;
			this.adjacencyList = new ArrayList<>();
			for(int i = 0; i <= n; i++) {
				adjacencyList.add(new ArrayList<>());
			} 
		}
		
		void addEdge(int src, int dest) {
			adjacencyList.get(src).add(dest);
			adjacencyList.get(dest).add(src);
		}
		
		boolean isCyclic(boolean[] visited, int v, int parent) {
			visited[v] = true;
			for(int i : adjacencyList.get(v)) {
				if(!visited[i]) {
					if(isCyclic(visited, i, v)) {
						return true;
					}
				} else if(i != parent) {
					return true;
				}
			}
			return false;
		}
		
		void findCycle() {
			boolean[] visited = new boolean[n];
			for(int i = 1; i < n; i++) {
				if(!visited[i] && isCyclic(visited, 1, -1)) {
					System.out.println("YES");
					return;
				}
			}
			System.out.println("NO");
		}
	}
	
	public static void main(String[] args) throws Exception {
		TwoWayAttack g = new TwoWayAttack();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		TwoWayAttack.Graph[] graphs = new TwoWayAttack.Graph[t];
		for(int i = 0; i < t; i++) {
			int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int n = arr[0];
			int m = arr[1];
			Graph graph = g.new Graph(n);
			for(int j = 0; j < m; j++) {
				int[] edge = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				graph.addEdge(edge[0], edge[1]);
			}
			graphs[i] = graph;
		}
		br.close();
		for(int i = 0; i < t; i++) {
			Graph graph = graphs[i];
			graph.findCycle();
		}
	}
}
