package algo.array;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayManipulationIntersection {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        ArrayList<Pair<Integer, Integer>> v = new ArrayList<Pair<Integer, Integer>>();

        Arrays.stream(queries)
                .filter(q -> q[2] != 0)
                .forEach(q -> {
                    int a;
                    int b;
                    int k;
                    a = q[0];
                    b = q[1];
                    k = q[2];


                    //storing the query
                    //this will add k in the prefix sum for index >= a
                    v.add(new Pair<Integer, Integer>(a, k));

                    //adding -1*k will remove k from the prefix sum for index > b
                    if (a != b) {
                        v.add(new Pair<Integer, Integer>(b + 1, -1 * k));
                    } else {
                        v.add(new Pair<Integer, Integer>(b, 0));
                    }
                });

        long mx = 0;
        long sum = 0;

        Collections.sort(v, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.first.compareTo(p2.first);
            }
        });

        for (int i = 0; i < v.size(); i++) {
            if(v.get(i).second == 0) {
                if(i < v.size()-1 && v.get(i+1).first != v.get(i).first) {
                    sum = 0;
                }
            } else {
                sum += v.get(i).second;
            }

            mx = Math.max(mx, sum);
        }

        return mx;
    }

    public static void main(String[] args) throws IOException {
        /*String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(String.valueOf(result));
        scanner.close();*/
        /*int n = 10;
        int[][] queries = {{1, 5, 3}, {4, 8, 7}, {6, 9, 1}};
        System.out.println(arrayManipulation(n, queries));*/
        int n = 4;
        int[][] queries = {{2, 3, 603}, {1, 1, 286}, {4, 4, 882}};
        System.out.println(arrayManipulation(n, queries));
        /*int n = 7;
        int[][] queries = {{2, 2, 286}, {3, 5, 603}, {6, 6, 882}, {6, 7, 1}};
        System.out.println(arrayManipulation(n, queries));*/
    }
}

final class Pair<T1, T2> {
    public T1 first;
    public T2 second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T1 firstValue, T2 secondValue) {
        first = firstValue;
        second = secondValue;
    }

    public Pair(Pair<T1, T2> pairToCopy) {
        first = pairToCopy.first;
        second = pairToCopy.second;
    }
}

