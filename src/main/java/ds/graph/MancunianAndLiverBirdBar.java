package ds.graph;

import java.io.*;

public class MancunianAndLiverBirdBar {
    public static void main(String[] args) throws IOException {
        FastReader fastReader = new FastReader();
        Print print = new Print();
        int N = fastReader.nextInt(), Q;
        int[] arr = new int[N + 1];
        int[] beforeUpdate = new int[N + 1];
        int[] afterUpdate = new int[N + 1];
        String query;
        for (int i = 1; i < N; i++) {
            arr[i] = fastReader.nextInt();
            if (arr[i] == 0) {
                beforeUpdate[i] += beforeUpdate[i - 1] + 1;
            } else {
                afterUpdate[i] += afterUpdate[i - 1] + 1;
            }
        }

        if (arr[N - 1] == 0 && arr[N - 2] == 0) {
            beforeUpdate[N] = beforeUpdate[N - 1] + 1;

        } else if (arr[N - 1] == 0) {
            beforeUpdate[N] = 2;
        } else {
            beforeUpdate[N] = 1;
        }


        if (arr[N - 1] == 1 && arr[N - 2] == 1) {
            afterUpdate[N] = afterUpdate[N - 1] + 1;

        } else if (arr[N - 1] == 1) {
            afterUpdate[N] = 2;
        } else {
            afterUpdate[N] = 1;
        }


        for (int i = N - 1; i >= 1; i--) {
            if (arr[i] == 1) {
                beforeUpdate[i] += beforeUpdate[i + 1] + 1;
                if (arr[i - 1] == 0 && i - 1 != 0) {
                    beforeUpdate[i] += beforeUpdate[i - 1];
                }
            } else {
                afterUpdate[i] += afterUpdate[i + 1] + 1;
                if (arr[i - 1] == 1 && i - 1 != 0) {
                    afterUpdate[i] += afterUpdate[i - 1];
                }
            }
        }


        Q = fastReader.nextInt();
        boolean reverse = false;
        while (Q > 0) {
            query = fastReader.readLine();
            if (query.charAt(0) == 'Q') {
                if (reverse)
                    print.println(afterUpdate[Integer.parseInt(query.substring(2))]);
                else
                    print.println(beforeUpdate[Integer.parseInt(query.substring(2))]);
            } else {
                reverse = !reverse;

            }
            Q--;
        }

        print.close();


    }

    private static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    private static class Print {
        private final BufferedWriter bw;

        public Print() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
}
