package ds.graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OliverBattle {

    static int bfs(int i, int j, int[][] adjMat, BitSet[] visited, int count) {
        visited[i].set(j);
        count++;
        int n = adjMat.length;
        int m = adjMat[0].length;
        if(i > 0 && i < n-1 && j > 0 && j < m-1) {
            if(adjMat[i-1][j] == 1 && visited[i-1].get(j) == false)
                count = bfs(i-1, j, adjMat, visited, count);
            if(adjMat[i+1][j] == 1 && visited[i+1].get(j) == false)
                count = bfs(i+1, j, adjMat, visited, count);
            if(adjMat[i][j-1] == 1 && visited[i].get(j-1) == false)
                count = bfs(i, j-1, adjMat, visited, count);
            if(adjMat[i][j+1] == 1 && visited[i].get(j+1) == false)
                count = bfs(i, j+1, adjMat, visited, count);

            if(adjMat[i-1][j-1] == 1 && visited[i-1].get(j-1) == false)
                count = bfs(i-1, j-1, adjMat, visited, count);
            if(adjMat[i-1][j+1] == 1 && visited[i-1].get(j+1) == false)
                count = bfs(i-1, j+1, adjMat, visited, count);

            if(adjMat[i+1][j-1] == 1 && visited[i+1].get(j-1) == false)
                count = bfs(i+1, j-1, adjMat, visited, count);
            if(adjMat[i+1][j+1] == 1 && visited[i+1].get(j+1) == false)
                count = bfs(i+1, j+1, adjMat, visited, count);
        }
        if(i == 0 && j >= 0 && j <= m-1) {
            if(j > 0 && j < m-1) {
                if (adjMat[0][j + 1] == 1 && visited[0].get(j + 1) == false)
                    count = bfs(0, j + 1, adjMat, visited, count);
                if (adjMat[0][j - 1] == 1 && visited[0].get(j - 1) == false)
                    count = bfs(0, j - 1, adjMat, visited, count);
            } else if(j == 0){
                if (adjMat[0][j+1] == 1 && visited[0].get(j+1) == false)
                    count = bfs(0, j+1, adjMat, visited, count);
            }
        }
        if(i == n-1 && j >= 0 && j <= m-1) {
            if(j > 0 && j < m-1) {
                if (adjMat[n-1][j + 1] == 1 && visited[n-1].get(j + 1) == false)
                    count = bfs(n-1, j + 1, adjMat, visited, count);
                if (adjMat[n-1][j - 1] == 1 && visited[n-1].get(j - 1) == false)
                    count = bfs(n-1, j - 1, adjMat, visited, count);
            } else if(j == 0){
                if (adjMat[n-1][j+1] == 1 && visited[n-1].get(j+1) == false)
                    count = bfs(n-1, j+1, adjMat, visited, count);
            }
        }
        if(j == 0 && i >= 0 && i <= n-1) {
            if(i > 0 && i < n-1) {
                if (adjMat[i+1][0] == 1 && visited[i+1].get(0) == false)
                    count = bfs(i+1, 0, adjMat, visited, count);
                if (adjMat[i-1][0] == 1 && visited[i-1].get(0) == false)
                    count = bfs(i-1, 0, adjMat, visited, count);
            } else if(i == 0) {
                if (adjMat[i+1][0] == 1 && visited[i+1].get(0) == false)
                    count = bfs(i+1, 0, adjMat, visited, count);
            }
        }
        if(j == m-1 && i >= 0 && i <= n-1) {
            if(i > 0 && i < n-1) {
                if (adjMat[i+1][m-1] == 1 && visited[i+1].get(m-1) == false)
                    count = bfs(i+1, m-1, adjMat, visited, count);
                if (adjMat[i-1][m-1] == 1 && visited[i-1].get(m-1) == false)
                    count = bfs(i-1, m-1, adjMat, visited, count);
            } else if(i == 0){
                if (adjMat[i+1][m-1] == 1 && visited[i+1].get(m-1) == false)
                    count = bfs(i+1, m-1, adjMat, visited, count);
            }
        }
        return count;
    }

    static void process(int n, int m, int[][] adjMat) {
        BitSet[] visited = new BitSet[n];
        for(int i = 0; i < n; i++) {
            visited[i] = new BitSet(m);
        }

        int totalTroops = 0;
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < m-1; j++) {
                if(adjMat[i][j] == 1 && visited[i].get(j)== false) {
                    System.out.println(bfs(i, j, adjMat, visited, 0));
                    totalTroops++;
                }
            }
        }
        System.out.println(totalTroops);
    }

    public static void main(String[] args) throws Exception {
        int n, m;
        int[][] adjMat;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = input[0];
            m = input[1];
            adjMat = new int[n][m];
            for(int i = 0; i < n; i++) {
                adjMat[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }
        process(n, m, adjMat);
        /*System.out.println(Arrays.stream(adjMat[0]).boxed().collect(Collectors.toList()));
        BitSet bs = new BitSet();
        IntStream.range(0, adjMat[0].length)
                .filter(i -> adjMat[0][i] == 1)
                .forEach(i -> bs.set(i));
        System.out.println(bs);*/
    }
}

/*
4 6
0 0 0 1 1 0
1 1 0 0 0 0
0 1 0 0 0 0
0 0 1 0 0 0
6 4
1 1 1 1
0 0 0 0
0 1 0 0
1 0 1 0
1 0 0 0
1 0 0 0
 */
