package ds.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathInGraph {

    static List<List<Integer>> createGraph(BufferedReader br, int N, int M) throws Exception {
        List<List<Integer>> G = new ArrayList<>();
        for(int i = 0; i < N+1; i++) {
            G.add(new ArrayList<>());
        }
        for(int e = 0; e < M; e++) {
            final String[] ip = br.readLine().split(" ");
            int u = Integer.parseInt(ip[0]);
            int v = Integer.parseInt(ip[1]);
            G.get(u).add(v);
            G.get(v).add(u);
        }
        return G;
    }

    static boolean BFS(List<List<Integer>> G, int S, int D) {
        int N = G.size();
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        visited[S] = true;
        while(!q.isEmpty()) {
            int u = q.poll();
            for(int v : G.get(u)) {
                if(!visited[v]) {
                    q.offer(v);
                    visited[v] = true;
                }
            }
        }
        return visited[D];
    }

    static boolean DFS(List<List<Integer>> G, int S, int D, boolean[] visited) {
        visited[S] = true;
        if(S == D) {
            return true;
        }
        for(int v : G.get(S)) {
            if(!visited[v] && DFS(G, v, D, visited)) {
                return true;
            }
        }
        return false;
    }

    static void solve(BufferedReader br, int Q, List<List<Integer>> G) throws Exception{
        for(int i = 0; i < Q; i++) {
            final String[] ip = br.readLine().split(" ");
            int S = Integer.parseInt(ip[0]);
            int D = Integer.parseInt(ip[1]);
            if(DFS(G, S, D, new boolean[G.size()])) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < t; i++) {
                System.out.println(String.format("Test Case #%d:",(i+1)));
                final String[] ip = br.readLine().split(" ");
                int N = Integer.parseInt(ip[0]);
                int M = Integer.parseInt(ip[1]);
                List<List<Integer>> G = createGraph(br, N, M);
                int Q = Integer.parseInt(br.readLine());
                solve(br, Q, G);
            }
        }
    }
}
