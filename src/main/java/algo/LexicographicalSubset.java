package algo;

import java.util.Scanner;
import java.util.Arrays;

/*
Given an array of unique integer elements, print all the subsets of the given array in lexicographical order. 

Input Format

First line of input contains T - number of test cases. 
Its followed by 2T lines, the first line contains N - the size of the array 
and second line contains the elements of the array. 

Constraints

1 <= T <= 100
1 <= N <= 10
0 <= A[i] <= 100

Output Format

For each test case, print the subsets of the given array in lexicographical order, separated by new line. 
Print an extra newline between output of different test cases.

Sample Input 0

2
3
5 15 3 
2
57 96 

Sample Output 0

3 
3 5 
3 5 15 
3 15 
5 
5 15 
15 

57 
57 96 
96 
 */
public class LexicographicalSubset {
    static char[][] subset(int[] arr, int n, int size) {
        Arrays.sort(arr);
        char[][] sets = new char[size][n];

        char[] a = new char[n];
        for(int i = 0; i < n; i++) {
            a[i] = (char)arr[i];
        }
        sets[0] = a;

        for(int i = 1; i < size; i++) {
            int e = i;
            int index = n-1;
            while(index >= 0) {
                if((e & 1) == 1) {
                    sets[i][index] = ' ';
                } else {
                    sets[i][index] = (char)arr[index];
                }
                index--;
                e = e >> 1;
            }
        }

        return sets;
    }

    static void printSets(char[][] sets, int n, int size) {
        for(int i = 1; i < size; i++) {
            for(int j = 0; j < n; j++) {
                if(sets[i][j] != ' ')
                    System.out.print((int)sets[i][j]+" ");
            }
            System.out.println();
        }
    }

    static char[][] shift(char[][] sets, int start, int end) {
        char[] temp = sets[end-1];
        for(int i = end-1; i > start; i--) {
            sets[i] = sets[i-1];
        }
        sets[start] = temp;
        return sets;
    }

    static char[][] sort(char[][] sets, int len, int n) {
        if(n == 0) {
            return sets;
        }
        sets = sort(sets, len, n-1);
        int m = n;
        int start = 0;
        int end = 0;
        while(m > 0 && start < len) {
            int k = m;
            while(k > 0 && start < len) {
                end = start + (1<<k);
                sets = shift(sets, start, end);
                start = end;
                k--;
            }
            start = start + 2;
            m--;
        }
        return sets;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            int n = in.nextInt();
            int size = 1<<n;
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            char[][] sets = subset(arr, n, size);
            sets = sort(sets, size, n);
            printSets(sets, n, size);
            System.out.println();
        }
    }
}
