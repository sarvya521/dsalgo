package ds.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinMaxWeight {

	public static void findPath(HashSet<ArrayList<Integer>> set, int[] prev, int node) {
		while (prev[node] != -1) {

			int curr = prev[node];

			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(node);
			temp.add(curr);
			if (set.contains(temp)) {
				set.remove(temp);
			}

			ArrayList<Integer> temp1 = new ArrayList<>();
			temp1.add(curr);
			temp1.add(node);
			if (set.contains(temp1)) {
				set.remove(temp1);
			}
			node = curr;
		}
	}

	public static void bfs2(ArrayList<ArrayList<Integer>> adjList, int parent, HashSet<ArrayList<Integer>> set) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> distance = new LinkedList<>();
		int n = adjList.size();

		int[] prev = new int[n];
		int[] distArray = new int[n];
		boolean[] visited = new boolean[n];
		queue.add(parent);
		distance.add(0);

		visited[parent] = true;
		distArray[parent] = 0;
		int max = 0;
		prev[parent] = -1;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			int dist = distance.poll();

			distArray[node] = dist;
			max = Math.max(dist, max);

			for (Integer child : adjList.get(node)) {
				if (!visited[child]) {
					visited[child] = true;
					queue.add(child);
					distance.add(dist + 1);
					prev[child] = node;
				}
			}
		}

		ArrayList<Integer> maxNodes = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (distArray[i] == max) {
				maxNodes.add(i);
				findPath(set, prev, i);
			}
		}
	}

	public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adjList, int parent) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> distance = new LinkedList<>();
		int n = adjList.size();

		int[] distArray = new int[n];
		boolean[] visited = new boolean[n];
		queue.add(parent);
		distance.add(0);

		visited[parent] = true;
		distArray[parent] = 0;
		int max = 0;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			int dist = distance.poll();

			distArray[node] = dist;
			max = Math.max(dist, max);

			for (Integer child : adjList.get(node)) {
				if (!visited[child]) {
					visited[child] = true;
					queue.add(child);
					distance.add(dist + 1);

				}
			}
		}

		ArrayList<Integer> maxNodes = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (distArray[i] == max) {
				maxNodes.add(i);
			}
		}
		return maxNodes;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int l = 0; l < t; l++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int sum = Integer.parseInt(s[1]);

			if (n == 1) {
				System.out.println(0);
				continue;
			}
			ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

			for (int i = 0; i <= n; i++) {
				adjList.add(new ArrayList<Integer>());
			}

			HashSet<ArrayList<Integer>> set = new HashSet<>();

			for (int i = 0; i < n - 1; i++) {
				s = br.readLine().split(" ");
				int u = Integer.parseInt(s[0]);
				int v = Integer.parseInt(s[1]);
				adjList.get(u).add(v);
				adjList.get(v).add(u);

				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(u);
				temp.add(v);
				set.add(temp);
			}

			ArrayList<Integer> maxNodes = bfs(adjList, 1); // find out leaf nodes of tree graph

			for (int i = 0; i < maxNodes.size(); i++) {
				bfs2(adjList, maxNodes.get(i), set); // figure out diameter for each leaf node, and remove all edges
														// which are part of these diameters
			}

			if (!set.isEmpty()) { // set will contain edges which are not part of diameter of a tree
				System.out.println(0); // there is atleast one edge which is not part of a diameter of a tree.
										// So here minimum possible maximum weight can be assigned to diameter edge is Zero
			} else {
				int max = sum / (n - 1); // hence set is empty, means each edge is part of atleast one diameter
				if (sum % (n - 1) != 0) {
					max += 1;
				}
				System.out.println(max);
			}

		}

	}
}
