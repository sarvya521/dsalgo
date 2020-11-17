package algo;

import java.io.*;
import java.util.*;

/*
Sample Input 0

4
4 710
13 1
6 4
605904 996510762

Sample Output 0

1420 2
13 1
12 2
7740895599216 78
 */
public class LcmHcf {
    /*static long hcf(long a, long b) {
        if (a == 0 || b == 0)
           return 0;
        if (a == b)
            return a;
        if (a > b)
            return hcf(a-b, b);
        return hcf(a, b-a);
    }*/

    static long hcf(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            long a = in.nextInt();
            long b = in.nextInt();
            long hcf = hcf(a, b);
            long lcm = a*(b/hcf);
            System.out.println(lcm+" "+hcf);
        }
        in.close();
    }
}
