package ds.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LearningGraph {
	static int a;
	class Graph {
		int n;
		int[] val;
		List<List<Integer>> edges;
		
		Graph(int n, int[] val) {
			this.n = n;
			this.val = val;
			this.edges = new ArrayList<List<Integer>>();
	        for(int i = 0; i <= n; i++) {
	            edges.add(new LinkedList<Integer>());
	        }
		}
		
		void addEdge(int src, int dest) {
			edges.get(src).add(dest);
			edges.get(dest).add(src);
		}
	}
	
	/*static void solve(final Graph g, final int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 1; i <= g.val.length; ++i) {
	        map.put(i, g.val[i-1]);
	    }
	    System.out.println(map);
	    System.out.println();
	    Map<Integer, Integer> sorted = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                LinkedHashMap::new));
	    System.out.println(sorted);
	    System.out.println();
	    List<Integer> sortedList = new ArrayList<Integer>(sorted.keySet());
	    
	    int n = g.edges.size();
		for(int i = 1; i < n; i++) {
			List<Integer> neighbours = g.edges.get(i);
			if(i == 14) {
				System.out.println("unsorted neighbours: " + neighbours);
				System.out.println(sortedList);
				
				List<Integer> list = neighbours.stream()
				         .sorted((e1, e2) -> g.val[ e1.intValue() - 1] == g.val[ e2.intValue() - 1] 
									? Integer.valueOf( e1.intValue() ).compareTo( Integer.valueOf( e2.intValue() ) )
									: Integer.valueOf( g.val[ e1.intValue() - 1] ).compareTo( Integer.valueOf( g.val[ e2.intValue() - 1] ) ) 
				          ).collect(Collectors.toList());
				
				System.out.println("**sorted neighbours: " + list);
				int ans = list.size() >= k ? list.get(list.size() - k) : -1;
				System.out.println(ans);
			}
			neighbours.sort(Comparator.comparingInt(sortedList::indexOf));
			if(i == 14) {
				System.out.println("**sorted neighbours: " + neighbours);
				System.out.println(neighbours.size() >= k ? neighbours.get(k-1) : -1);
				return;
			}
			int ans = neighbours.size() >= k ? neighbours.get(k-1) : -1;
			System.out.println(ans);
		}
	}*/
	
	static void solve(final Graph g, final int k) {
		int n = g.edges.size();
		for(int i = 1; i < n; i++) {
			List<Integer> neighbours = g.edges.get(i);
			List<Integer> sortedList = neighbours.stream()
			         .sorted((e1, e2) -> g.val[ e1.intValue() - 1] == g.val[ e2.intValue() - 1] 
								? Integer.valueOf( e1.intValue() ).compareTo( Integer.valueOf( e2.intValue() ) )
								: Integer.valueOf( g.val[ e1.intValue() - 1] ).compareTo( Integer.valueOf( g.val[ e2.intValue() - 1] ) ) 
			          ).collect(Collectors.toList());
			
			int ans = sortedList.size() >= k ? sortedList.get(sortedList.size() - k) : -1;
			System.out.println(ans);
		}
	}
	
	/*public static void main(String[] args) {
		List<Integer> neighbours = new ArrayList<>();
		neighbours.add(2);
		neighbours.add(3);
		neighbours.add(4);
		int[] val = new int[] {20, 11, 10, 15};
		List<Integer> list = neighbours.stream().map(e -> val[ e.intValue() - 1]).collect(Collectors.toList());
		System.out.println(list);
		
		list = neighbours.stream()
				.map(e -> val[ e.intValue() - 1])
				.sorted((e1, e2) -> e1.compareTo(e2) )
				.collect(Collectors.toList());
		System.out.println(list);
		
		
		list = neighbours.stream()
				.sorted((e1, e2) -> Integer.valueOf( val[ e1.intValue() - 1] ).compareTo(Integer.valueOf( val[ e2.intValue() - 1] )) )
				.collect(Collectors.toList());
		System.out.println(list);
		
		int[] val = new int[] {20, 11, 10, 15, 11, 9, 13};
		
		List<Integer> sortedNodes = IntStream.range(0, val.length)
				.boxed().sorted((i, j) -> val[i] == val[j]
						? Integer.valueOf(i).compareTo(Integer.valueOf(j))
						: Integer.valueOf(val[i]).compareTo(Integer.valueOf(val[j])))
				.collect(Collectors.toList());
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < val.length; ++i) {
	        map.put(i, val[i]);
	    }
	    
	    Map<Integer, Integer> sorted = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(Collectors.toMap(e -> e.getKey() + 1, e -> e.getValue(), (e1, e2) -> e2,
                LinkedHashMap::new));
	    
	    System.out.println("sortedValues :" + sorted.values());
		System.out.println("sortedNodes :" + sorted.keySet());
		
		List<Integer> neighbours = new ArrayList<>();
		neighbours.add(2);
		neighbours.add(3);
		neighbours.add(4);
		
		System.out.println("neighbours :" + neighbours);

		List<Integer> list = sorted.keySet().stream()
		.filter(node -> neighbours.stream().collect(Collectors.toList()).contains(node))
		.collect(Collectors.toList());
		
		System.out.println(list);
	}*/
	
	public static void main(String args[] ) throws Exception {
		long curTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        final int n = Integer.parseInt(input[0]);
        final int m = Integer.parseInt(input[1]);
        final int k = Integer.parseInt(input[2]);
        
        int[] val = Stream.of(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
        
        Graph g = new LearningGraph().new Graph(n, val);
        for(int i = 0; i < m; i++) {
            int[] arr = Stream.of(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            g.addEdge(arr[0], arr[1]);
        }
        solve(g, k);
		System.out.println(System.currentTimeMillis() - curTime + "ms");
    }

}
