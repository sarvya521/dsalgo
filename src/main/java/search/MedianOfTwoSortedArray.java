package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sarvesh
 * @since
 */
public class MedianOfTwoSortedArray {

    private static int BS1(int[] arr, int sz, int k) {
        int lo = 0;
        int hi = sz;
        int ans = -1;
        int mid = 0;
        while(lo <= hi) {
            mid = (lo + hi) / 2;
            if(arr[mid] < k) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans + 1;
    }

    private static int BS2(int[] arr, int sz, int k) {
        int lo = 0;
        int hi = sz;
        int ans = sz;
        int mid = 0;
        while(lo <= hi) {
            mid = (lo + hi) / 2;
            if(arr[mid] > k) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return sz-ans;
    }

    private static int solveWithBS(int[] A, int N, int[] B, int M) {
        int lo = Math.min(A[0], B[0]);
        int hi = Math.max(A[N-1], B[M-1]);
        int mid = 0;
        while(lo <= hi) {
            mid = (lo + hi) / 2;
            int x = BS1(A, N, mid) + BS1(B, M, mid);
            int y = BS2(A, N, mid) + BS2(B, M, mid);
            if(x == y) {
                return mid;
            }
            if(x < y) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] A = new int[]{-3, 5, 8, 12, 13, 18, 20, 25, 28};
            int[] B = new int[]{-8, -1, 15, 23, 30, 45};
            int N = A.length;
            int M = B.length;
            System.out.println(solveWithBS(A, N, B, M));
        }
    }
}
