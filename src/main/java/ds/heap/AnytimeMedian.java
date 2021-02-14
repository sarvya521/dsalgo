package ds.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sarvesh
 * @since
 */
public class AnytimeMedian {

    private static String solve(int[] arr, int n) {
        PriorityQueue<Integer> A = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> B = new PriorityQueue<>();
        StringBuilder builder = new StringBuilder();
        A.offer(arr[0]);
        builder.append(arr[0]).append(" ");
        for(int i = 1; i < n; i++) {
            if(arr[i] < A.peek()) {
                A.offer(arr[i]);
            } else {
                B.offer(arr[i]);
            }

            if((A.size() - B.size()) < 0 || (A.size() - B.size()) > 1) {
                if(A.size() > B.size()) {
                    B.offer(A.poll());
                } else {
                    A.offer(B.poll());
                }
            }
            builder.append(A.peek()).append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                builder.append(solve(arr, n)).append(System.lineSeparator());
            }
            System.out.println(builder);
        }
    }
}
