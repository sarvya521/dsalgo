package ds.graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class FlightPlan {
	
	class Graph {
		int vertices;
		List<PriorityQueue<Integer>> adjList;
		
		Graph(int vertices) {
			this.vertices = vertices;
			this.adjList = new ArrayList<>();
			for(int i = 0; i <= vertices; i++) {
				adjList.add(new PriorityQueue<Integer>(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					}
				}));
			}
		}
		
		void addEdge(int src, int dest) {
			this.adjList.get(src).add(dest);
			this.adjList.get(dest).add(src);
		}
		
		void bfs(int t, int c, int dest, int src) {
			BitSet visited = new BitSet(vertices+1);
			Queue<Integer> q = new LinkedList<>();
			q.add(src);
			visited.set(src);
			int[] parent = new int[vertices+1];
			parent[src] = 0;
			int[] nodeLevel = new int[vertices+1];
			nodeLevel[src] = 0;
			while(!q.isEmpty()) {
				int s = q.poll();
				PriorityQueue<Integer> neighbours = adjList.get(s);
				while(!neighbours.isEmpty()) {
					int city = neighbours.poll();
					if(!visited.get(city)) {
						nodeLevel[city] = nodeLevel[s] + 1;
						parent[city] = s;
						if(city == dest) {
							int time = nodeLevel[city] * c + ((nodeLevel[city] - 1) * (t - (c % t)));
							System.out.println("node level of "+dest+" = "+nodeLevel[dest]);
							System.out.println("total time taken = "+time);
							int p = city;
							String path = ""+p;
							while(p != src) {
								p = parent[p];
								path = p + "->"+ path;
							}
							System.out.println(path);
							return;
						}
						visited.set(city);
						q.add(city);
					}
				}
			}
		}
	}
	
	static void process(Graph g, int t, int c, int x, int y) {
		if(x == y) {
	        System.out.println(x);
	        System.out.println(x);
	        return;
	    }
		g.bfs(t, c, y, x);
	}
	
	public static void main(String[] args) throws Exception {
		FlightPlan f = new FlightPlan();
		Graph graph = null;
		int[] input = null;
		int[] xy = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int n = input[0];
			int m = input[1];
			graph = f.new Graph(n);
			for(int i = 0; i < m; i++) {
				int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				graph.addEdge(arr[0], arr[1]);
			}
			xy = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		} catch (Exception e) {
			throw new Exception(e);
		}
		process(graph, input[2], input[3], xy[0], xy[1]);
	}

}
/*
10 13 3 5
1 2
1 3
1 4
2 5
2 6
3 7
4 8
4 9
6 7
7 8
8 9
7 10
8 10
1 10
*/
