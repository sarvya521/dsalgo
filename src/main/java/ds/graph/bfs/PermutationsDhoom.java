package ds.graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PermutationsDhoom {
	
	private static void process(int[] input, Deque<Integer> keys) {
		final int MOD = 100000;
	    final int MAX = 100000;
	    int[] way = new int[MAX];
	    
		final int root = input[0];
		final int ans = input[1];
		way[root] = 0;
		keys.forEach(n -> way[n] = 1);
		
		while(!keys.isEmpty()) {
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		PermutationsDhoom p = new PermutationsDhoom();
		int[] input = null;
		Deque<Integer> keys = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			br.readLine(); // skip
			final int start = input[0];
			keys = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().map(n -> n * start).sorted().collect(Collectors.toCollection(LinkedList::new));
		} catch (Exception e) {
			throw new Exception(e);
		}
		process(input, keys);
	}

	/*
	static final int MOD = 100000;
    static final int MAX = 100000;
    static int[] way = new int[MAX];
    static int[] arrKey;
 
    public static void main(String[] args) {
        int nKey, nUnlock;
        Scanner sc = new Scanner(System.in);
        int keyStart = sc.nextInt();
        nUnlock = sc.nextInt();
 
        nKey = sc.nextInt();
        arrKey = new int[nKey];//array number
 
 
        for (int i = 0; i < nKey; i++) {
            arrKey[i] = sc.nextInt();
        }
 
        System.out.print(BFS(keyStart, nUnlock, nKey));
        sc.close();
    }
 
    private static int BFS(int start, int numUnlock, int numKey) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        Arrays.fill(way, -1);
        way[start] = 0;
 
        while (!q.isEmpty()) {
            int nextKey = q.poll();
            for (int i = 0; i < numKey; i++) {
                long tmp = ((long) arrKey[i] * nextKey) % MOD;
                int crValue = (int) tmp;
                if (way[crValue] == -1) {
                    // cong don voi duong di tai dinh truoc do
                    way[crValue] = way[nextKey] + 1;
                    q.add(crValue);
 
                    // kiem tra gia tri sau khi nhan da khop voi gia tri unlock chua
                    if (crValue == numUnlock)
                        return way[crValue];
                }
            }
        }
        return -1;
    }*/
}
