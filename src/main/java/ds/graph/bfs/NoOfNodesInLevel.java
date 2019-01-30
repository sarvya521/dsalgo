package ds.graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Stream;

public class NoOfNodesInLevel {
	
	class Graph {
		int vertices;
		List<List<Integer>> adjList;
		
		Graph(int vertices) {
			this.vertices = vertices;
			this.adjList = new ArrayList<>();
			for(int i = 0; i <= vertices; i++) {
				adjList.add(new ArrayList<Integer>());
			}
		}
		
		void addEdge(int src, int dest) {
			this.adjList.get(src).add(dest);
			this.adjList.get(dest).add(src);
		}
		
		void bfs_nodeLevel(int s, BitSet visited, int[] nodeLevel) {
			Queue<Integer> queue = new LinkedList<>();
			queue.add(s);
			visited.set(s);
			nodeLevel[s] = 0;
			while (!queue.isEmpty()) {
				int v = queue.poll();
				adjList.get(v).stream().filter(n -> !visited.get(n)).forEach(n -> {
					queue.add(n);
					visited.set(n);
					nodeLevel[n] = nodeLevel[v] + 1;
				});
			}
		}
		
		void bfs_levelNodes(int s, BitSet visited, Map<Integer, Integer> levelNodes) {
			Queue<Integer> queue = new LinkedList<>();
			int[] nodeLevel = new int[vertices + 1];
			queue.add(s);
			visited.set(s);
			int level = 0;
			levelNodes.put(level, 1);
			while (!queue.isEmpty()) {
				int v = queue.poll();
				for(int n : adjList.get(v)) {
					if(!visited.get(n)) {
						queue.add(n);
						visited.set(n);
						nodeLevel[n] = nodeLevel[v] + 1;
						Integer nodes = levelNodes.get(nodeLevel[n]);
						if(nodes == null) {
							nodes = 0;
						}
						levelNodes.put(nodeLevel[n], nodes+1);
					}
				}
			}
		}
		
		void bfs_levelNodes(int s, BitSet visited, Map<Integer, Integer> levelNodes, int _level) {
			Queue<Integer> queue = new LinkedList<>();
			int[] nodeLevel = new int[vertices + 1];
			queue.add(s);
			visited.set(s);
			int level = 0;
			levelNodes.put(level, 1);
			while (!queue.isEmpty()) {
				int v = queue.poll();
				for(int n : adjList.get(v)) {
					if(!visited.get(n)) {
						queue.add(n);
						visited.set(n);
						nodeLevel[n] = nodeLevel[v] + 1;
						if(nodeLevel[n] > _level) {
							return;
						}
						Integer nodes = levelNodes.get(nodeLevel[n]);
						if(nodes == null) {
							nodes = 0;
						}
						levelNodes.put(nodeLevel[n], nodes+1);
					}
				}
			}
		}
	}
	
	static void processNodeLevel(Graph g) {
		BitSet visited = new BitSet(g.vertices + 1);
		int[] nodeLevel = new int[g.vertices + 1];
		g.bfs_nodeLevel(1, visited, nodeLevel);
		System.out.println("level of node :::");
		Arrays.stream(nodeLevel).forEach(i -> { System.out.println(i); });
	}
	
	static void processLevelNodes(Graph g) {
		BitSet visited = new BitSet(g.vertices + 1);
		Map<Integer, Integer> levelNodes = new HashMap<>();
		g.bfs_levelNodes(1, visited, levelNodes);
		System.out.println("no of nodes at each level :::");
		levelNodes.forEach((k, v) -> {System.out.println("level="+k+" - nodes="+v); });
	}
	
	static void processLevelNodes(Graph g, int level) {
		BitSet visited = new BitSet(g.vertices + 1);
		Map<Integer, Integer> levelNodes = new HashMap<>();
		g.bfs_levelNodes(1, visited, levelNodes, level);
		System.out.println("\n\nlevel="+level+" - nodes="+levelNodes.get(level)); 
	}

	public static void main(String[] args) throws Exception {
		NoOfNodesInLevel g = new NoOfNodesInLevel();
		Graph graph = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			graph = g.new Graph(n);
			for(int i = 0; i < n-1; i++) {
				int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				graph.addEdge(arr[0], arr[1]);
			}
		}
		processNodeLevel(graph);
		processLevelNodes(graph);
		processLevelNodes(graph, 2);
	}

}
