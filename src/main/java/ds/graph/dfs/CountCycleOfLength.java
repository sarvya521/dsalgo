package ds.graph.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.Stream;

public class CountCycleOfLength {
    static int V = 8;
    static int count = 0;

    static void DFS(int graph[][], boolean marked[], int n, int vert, int start) {
        /* mark the vertex vert as visited */
        marked[vert] = true;
        /* if the path of length (n-1) is found */
        if (n == 0) {
            //mark vert as un-visited to
            // make it usable again
            marked[vert] = false;
            // Check if vertex vert end
            // with vertex start
            if (graph[vert][start] == 1) {
                count++;
                return;
            } else {
                return;
            }
        }
        // For searching every possible path of length (n-1)
        for (int i = 0; i < V; i++) {
            if (!marked[i] && graph[vert][i] == 1) {
                // DFS for searching path by decreasing length by 1
                DFS(graph, marked, n - 1, i, start);
            }
        }
        // marking vert as unvisited to make it usable again
        marked[vert] = false;
    }

    // Count cycles of length N in an undirected and connected graph.
    static int countCycles(int graph[][], int n) {
        // all vertex are marked un-visited initially.
        boolean marked[] = new boolean[V];
        // Searching for cycle by using v-n+1 vertices
        for (int i = 0; i < V - (n - 1); i++) {
            DFS(graph, marked, n - 1, i, i);
            // ith vertex is marked as visited and will not be visited again
            marked[i] = true;
        }
        return count / 2;
    }

    private static void process() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BitSet bs[] = new BitSet[n];
        for (int i = 0; i < n; i++) {
            bs[i] = new BitSet();
            for (int j = 0; j < n; j++) {
                if (scanner.nextInt() == 1) {
                    bs[i].set(j);
                }
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                BitSet temp = (BitSet) bs[i].clone();
                BitSet temp1 = (BitSet) bs[j].clone();
                temp.and(temp1);
                int k = temp.cardinality();
                res += (k * (k - 1) / 2);
            }
        }
        res /= 2;
        System.out.println(res);
    }

    // driver code
    public static void main(String[] args) throws Exception {
        process();
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        int graph[][] = new int[V][V];
        for(int i = 0; i < V; i++) {
            graph[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();
        int n = 4;
        System.out.println("Total cycles of length " + n + " are " + countCycles(graph, n));*/
        /*V = 8;
        int graph[][] = {
                {0, 1, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 0, 1, 0}};
        */
    }


}