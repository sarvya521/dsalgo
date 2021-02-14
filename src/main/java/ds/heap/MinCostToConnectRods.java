package ds.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostToConnectRods {

    // The main function that returns the
    // minimum cost to connect n ropes of
    // lengths stored in len[0..n-1]
    static int solve(int len[], int n) {
        int cost = 0; // Initialize result

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.stream(len).forEach(minHeap::offer);

        // Iterate while size of heap doesn't become 1
        while (minHeap.size() != 1) {
            // Extract two minimum length ropes from min heap
            int min = minHeap.poll();
            int sec_min = minHeap.poll();

            cost += (min + sec_min); // Update total cost

            // Insert a new rope in min heap with length equal to sum
            // of two extracted minimum lengths
            minHeap.offer(min + sec_min);
        }

        // Finally return total minimum
        // cost for connecting all ropes
        return cost;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                System.out.println(solve(arr, n));
            }
        }
    }
}
