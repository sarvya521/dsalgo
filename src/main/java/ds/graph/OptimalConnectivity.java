package ds.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class OptimalConnectivity {
	
	private static final String YES = "YES";
	private static final String NO = "NO";
	
	class Network {
		int n;
		List<Computer> computers;
		Network(int n) {
			this.n = n;
			this.computers = new ArrayList<Computer>();
			for(int i = 0; i <= n; i++) {
				this.computers.add(new Computer(i));
			}
		}
		
		void addEdge(int[] arr) {
			computers.get(arr[0]).neighbours.add(new Link(computers.get(arr[1]), arr[2]));
			computers.get(arr[1]).neighbours.add(new Link(computers.get(arr[0]), arr[2]));
		}
		
		void checkOptimization(int[] arr) {
			Computer src = computers.get(arr[0]);
			Computer dest = computers.get(arr[1]);
			int newLag = arr[2];
			//System.out.println("newLag ==> " + newLag);
			PriorityQueue<Link> pq1 = src.neighbours;
			//System.out.println(src + " ==> " + pq1);
			
			Link link;
			Iterator<Link> iter = pq1.iterator();
			while(iter.hasNext()) {
				link = iter.next();
				if(link.dest.neighbours.size() > 1 && link.lag > newLag) {
					//System.out.println(YES + " link = "+src+"->"+link+" can be removed.");
					System.out.println(YES);
					return;
				}
			}
			
			PriorityQueue<Link> pq2 = dest.neighbours;
			//System.out.println(dest + " ==> " + pq2);
			iter = pq2.iterator();
			while(iter.hasNext()) {
				link = iter.next();
				if(link.dest.neighbours.size() > 1 && link.lag > newLag) {
					//System.out.println(YES + " link = "+dest+"->"+link+" can be removed.");
					System.out.println(YES);
					return;
				}
			}
			System.out.println(NO);
		}
		
		/*void checkOptimization(int[] arr) {
			Computer src = computers.get(arr[0]);
			Computer dest = computers.get(arr[1]);
			int newLag = arr[2];
			//System.out.println("newLag ==> " + newLag);
			PriorityQueue<Link> pq1 = src.neighbours;
			//System.out.println(src + " ==> " + pq1);
			
			Link link;
			int skipLag = 0;
			Iterator<Link> iter = pq1.iterator();
			while(iter.hasNext()) {
				link = iter.next();
				if(link.dest.neighbours.size() > 1 && link.lag > newLag) {
					System.out.println(YES + " link = "+src+"->"+link+" can be removed.");
					return;
				}
				if(link.dest.neighbours.size() > 1) {
					if(link.lag > newLag) {
						//System.out.println(YES + " link = "+src+"->"+link+" can be removed.");
						System.out.println(YES);
						return;	
					} else {
						skipLag += link.lag;
						if(skipLag > newLag) {
							//System.out.println(YES + " multiple links can be removed.");
							System.out.println(YES);
							return;
						}
					}	
				}
				
			}
			
			PriorityQueue<Link> pq2 = dest.neighbours;
			//System.out.println(dest + " ==> " + pq2);
			skipLag = 0;
			iter = pq2.iterator();
			while(iter.hasNext()) {
				link = iter.next();
				if(link.dest.neighbours.size() > 1 && link.lag > newLag) {
					System.out.println(YES + " link = "+dest+"->"+link+" can be removed.");
					return;	
				}
				if(link.dest.neighbours.size() > 1) {
					if(link.lag > newLag) {
						//System.out.println(YES + " link = "+dest+"->"+link+" can be removed.");
						System.out.println(YES);
						return;	
					} else {
						skipLag += link.lag;
						if(skipLag > newLag) {
							//System.out.println(YES + " multiple links can be removed.");
							System.out.println(YES);
							return;
						}
					}					
				}
			}
			System.out.println(NO);
		}*/
		
	}
	
	public static void main(String[] args) throws Exception {
		OptimalConnectivity oc = new OptimalConnectivity();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Network network = oc.new Network(n);
		for(int i = 0; i < n - 1; i++) {
			int[] arr = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
			network.addEdge(arr);
		}
		int q = Integer.parseInt(br.readLine());
		for(int i = 0; i < q; i++) {
			int[] arr = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
			//if(i+1 == 5718 || i+1 == 6376 || i+1 == 18727) {
				network.checkOptimization(arr);	
			//}
		}
	}
	
	class Link {
		Computer dest;
		Integer lag;
		
		Link(Computer dest, Integer lag) {
			super();
			this.dest = dest;
			this.lag = lag;
		}

		@Override
		public String toString() {
			return dest + " - " + lag;
		}
	}
	
	class Computer {
		int id;
		PriorityQueue<Link> neighbours = new PriorityQueue<Link>(new Comparator<Link>() {
			@Override
			public int compare(Link l1, Link l2) {
				return l2.lag.compareTo(l1.lag);
			}
		});
		
		public Computer(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return String.valueOf(id);
		}
	}
}
