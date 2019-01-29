package ds.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class BuggyBot {

    static void solve(int n, List<List<Integer>> graph, int[][] karr) {
        BitSet bs = new BitSet(n);
        List<List<Integer>> parent = new ArrayList<List<Integer>>(n);
        for(int i = 0; i <= n; i++) {
            parent.add(new ArrayList<Integer>());
        }
        int rightPos = 1;
        for (int[] arr : karr) {
            int x = arr[0];
            int y = arr[1];
            for(int v : graph.get(rightPos)) {
                bs.set(v);
                parent.get(v).add(rightPos);
            }
            graph.get(rightPos).clear();
            if (rightPos == x) {
                rightPos = y;
            }
            if (bs.get(x)) {
                bs.set(y);
                bs.clear(x);

                for (int v : parent.get(x)) {
                    graph.get(v).add(x);
                }
                parent.get(x).clear();
            }
        }
        bs.set(rightPos);
        for (int v : graph.get(rightPos)) {
            bs.set(v);
        }
        int possibleFinalNodes = bs.cardinality();
        System.out.println(possibleFinalNodes);
        System.out.println(bs.toString().replace("{", "").replace("}", ""));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        List<List<Integer>> graph = new ArrayList<List<Integer>>(n);
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        int m = input[1];
        for(int i = 0; i < m; i++) {
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(arr[0]).add(arr[1]);
        }
        int k = input[2];
        int[][] karr = new int[k][2];
        for(int i = 0; i < k; i++) {
            karr[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();
        solve(n, graph, karr);
    }
}
/*
#include <iostream>
#include <bits/stdc++.h>
#define ll long long

using namespace std;

vector<int> graph[100002];
bool buggyNodes[100002];
set<int> toRestoreParents[100002];
int result[100002];

int main()
{
ios::sync_with_stdio(false);
memset(buggyNodes, false, sizeof(buggyNodes));

int n, m, k, a, b, x, y;
cin >> n >> m >> k;
for(int i = 0; i < m; i++)
{
cin >> a >> b;
graph[a].push_back(b);
}
int robustPosition = 1;
for(int i = 0; i < k; i++)
{
cin >> x >>y;

//Buggy Steps
for(int v : graph[robustPosition])
{
buggyNodes[v] = true;
toRestoreParents[v].insert(robustPosition);
}
//Remove from graph to prevent visiting it another time using buggy step.
graph[robustPosition].clear();

//Robust Step
if(robustPosition == x)
robustPosition = y;

if(buggyNodes[x])
{
buggyNodes[y] = true;
buggyNodes[x] = false;

//Restore links between nodes because we can reach this node from normal step.
for(int v : toRestoreParents[x])
graph[v].push_back(x);

toRestoreParents[x].clear();
}
}
int numberOfPossiblePlaces = 0;
buggyNodes[robustPosition] = true;

//Last Buggy Step
for(int v : graph[robustPosition])
buggyNodes[v] = true;

for(int i = 1; i <= n; i++)
{
//Represents the possible places that can the robot be in.
if(buggyNodes[i])
result[numberOfPossiblePlaces++] = i;
}

cout << numberOfPossiblePlaces << endl;
for(int i = 0; i < numberOfPossiblePlaces - 1; i++)
cout << result[i] << " ";
cout << result[numberOfPossiblePlaces - 1];

return 0;
}
*/
/*
5 6 4
2 1
2 3
3 5
5 2
5 4
1 2
3 5
2 3
2 1
2 3

3
1 2 3
*/