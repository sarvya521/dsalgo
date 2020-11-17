package ds.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class OptimalConnectivity2 {
	
	private static final String YES = "YES";
	private static final String NO = "NO";
	
	class Network {
		int n;
		List<List<Integer>> computers;
		List<Link> links;
		Network(int n) {
			this.n = n;
			this.computers = new ArrayList<List<Integer>>();
			for(int i = 0; i <= n; i++) {
				this.computers.add(new ArrayList<Integer>());
			}
			this.links = new ArrayList<Link>();
		}
		
		void addLink(int[] arr) {
			computers.get(arr[0]).add(arr[1]);
			computers.get(arr[1]).add(arr[0]);
			links.add(new Link(arr[0], arr[1], arr[2]));
		}
		
		void checkOptimization(int[] arr) {
			int src = arr[0];
			int dest = arr[1];
			int newLag = arr[2];
			if(links.get(0).lag <= newLag) {
				System.out.println(NO);
				return;
			}
			for(Link link : links) {
				if(link.lag > newLag) {
					if((link.src == src || link.src == dest)
							|| (link.dest == src || link.dest == dest)) {
						System.out.println(YES);
						return;
					}
				} else if(link.lag < newLag) {
					System.out.println(NO);
					return;
				}
			}
			System.out.println(NO);
		}
	}
	
	public static void main(String[] args) throws Exception {
		OptimalConnectivity2 oc = new OptimalConnectivity2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Network network = oc.new Network(n);
		for(int i = 0; i < n - 1; i++) {
			int[] arr = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
			network.addLink(arr);
		}
		Collections.sort(network.links, new Comparator<Link>() {
			@Override
			public int compare(Link l1, Link l2) {
				return l2.lag.compareTo(l1.lag);
			}
		});
		int q = Integer.parseInt(br.readLine());
		for(int i = 0; i < q; i++) {
			int[] arr = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
			//if(i+1 == 9909) {
				network.checkOptimization(arr);	
			//}
		}
	}
	
	class Link {
		int src;
		int dest;
		Integer lag;
		
		Link(int src, int dest, Integer lag) {
			super();
			this.src = src;
			this.dest = dest;
			this.lag = lag;
		}

		@Override
		public String toString() {
			return src + " <-> " + dest + " = " + lag;
		}
	}
	
}
