package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FLIP {

    /*private static int countAlternateBits(int x) {
        int count = 0;
        while(x != 0) {
            if((x & 1)==1) {
                count++;
            }
            x = x >> 2;
        }
        return count;
    }

    private static int solve(int a, int b) {
        int c = a ^ b;
        if(c == 0) {
            return 0;
        }
        int d = countAlternateBits(c);
        int e = countAlternateBits(c >> 1);
        if(d >= e) {
            return 1 + e;
        } else {
            return 1 + d;
        }
    }*/

    private static int solve(String a, String b) {
        int count = 0;
        int n = a.length();
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        for(int i = 0; i < n; i++) {
            if(x[i] != y[i]) {
                int j = i;
                while(j < n && x[j] != y[j]) {
                    x[j] = y[j];
                    j = j + 2;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        /*try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while(t > 0) {
                int a = Integer.parseInt(br.readLine(), 2);
                int b = Integer.parseInt(br.readLine(), 2);
                System.out.println(solve(a, b));
                t --;
            }
        }*/
        /*System.out.println(solve(Integer.parseInt("1001", 2), Integer.parseInt("1011", 2)));//1
        System.out.println(solve(Integer.parseInt("10010", 2), Integer.parseInt("11001", 2)));//2
        System.out.println(solve(Integer.parseInt("100100", 2), Integer.parseInt("110011", 2)));//2
        System.out.println(solve(Integer.parseInt("0001", 2), Integer.parseInt("1000", 2)));//2
        System.out.println(solve(Integer.parseInt("100001", 2), Integer.parseInt("110111", 2)));//2
        System.out.println(solve(Integer.parseInt("000000", 2), Integer.parseInt("111111", 2)));//4
        System.out.println("===============================");
        System.out.println(solve("1001", "1011"));//1
        System.out.println(solve("10010", "11001"));//2
        System.out.println(solve("100100", "110011"));//2
        System.out.println(solve("0001", "1000"));//2
        System.out.println(solve("100001", "110111"));//2*/
        System.out.println(solve("000000", "111111"));//4
    }
}
