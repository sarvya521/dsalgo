package codechef;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class RGAME {

    static final int MOD = (int)1e9 + 7;

    static int sum = 0;

    static void bruteSolve(String s, int[] a)
    {
        int idx1 = s.charAt(0) - '0';
        int idx2 = s.charAt(s.length() - 1) - '0';
        if (s.length() == a.length)
        {

            for (int i = 1; i < s.length(); i++)
                sum += a[s.charAt(i) - '0'] * a[s.charAt(i - 1) - '0'];
            System.out.println(s);
            return;
        }
        int idx = s.length();
        if (idx == idx1 || idx == idx2)
            throw new RuntimeException();

        //        sum += a[idx1] * a[idx];
        bruteSolve(s + idx, a);
        //        sum += a[idx2] * a[idx];
        bruteSolve(idx + s, a);
    }

    static int solve(int[] a)
    {
        int sz = 1;
        int def = 0;
        int sum = a[0] + a[0];

        for (int i = 1; i < a.length; i++)
        {
            def = (int) ((2 * def + 1L * sum * a[i]) % MOD);
            sz <<= 1;
            if (sz >= MOD)
                sz -= MOD;
            sum = (int)((sum + 1L * sz * a[i]) % MOD);
        }
        return def;
    }

    public static void main(String[] args) throws IOException
    {
        /*PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int tests = InputReader.nextInt();
        while (tests-- != 0)
        {
            int[] a = new int[InputReader.nextInt() + 1];
            for (int i = 0; i < a.length; i++)
                a[i] = InputReader.nextInt();
            out.println(solve(a));
        }
        out.close();*/
        bruteSolve("0", new int[]{1, 2, 1});
    }

    private static class InputReader
    {

        static java.io.BufferedInputStream in = new java.io.BufferedInputStream(System.in);
        static byte[] buf = new byte[1 << 20];
        static int bytesRead;
        static int pos = -1;

        static
        {
            try {
                bytesRead = in.read(buf);
            }
            catch (java.io.IOException e)
            {
            }
        }

        static int nextInt() throws java.io.IOException
        {
            while (++pos < bytesRead && (buf[pos] < 48 || buf[pos] > 57));//parsing unwanted data
            while (pos == bytesRead)
            {
                bytesRead = in.read(buf);
                pos = -1;
                while (++pos < bytesRead && (buf[pos] < 48 || buf[pos] > 57));
            }
            pos--;
            int n = 0;
            while (++pos < bytesRead && buf[pos] > 47 && buf[pos] < 58)
                n = n * 10 + buf[pos] - '0';
            while (pos == bytesRead)
            {
                bytesRead = in.read(buf);
                pos = -1;
                while (++pos < bytesRead && buf[pos] > 47 && buf[pos] < 58)
                    n = n * 10 + buf[pos] - '0';
            }
            return n;
        }
    }
}