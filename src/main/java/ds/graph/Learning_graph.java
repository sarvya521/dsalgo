package ds.graph;

//package com.company;

import java.io.*;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class Learning_graph implements Runnable {
	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();

			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}

				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		public int nextInt() {
			int c = read();

			while (isSpaceChar(c))
				c = read();

			int sgn = 1;

			if (c == '-') {
				sgn = -1;
				c = read();
			}

			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));

			return res * sgn;
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;

			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public double nextDouble() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));

			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return readString();
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

	public static void main(String args[]) throws Exception {
		new Thread(null, new Learning_graph(), "Learning_graph", 1 << 26).start();
	}

	public void run() {
		long curTime = System.currentTimeMillis();
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = 3, m, k;
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		Vertex[] v = new Vertex[n];
		for (int i = 0; i < n; i++) {
			v[i] = new Vertex();
			v[i].val = in.nextInt();
			v[i].idx = i;
		}
		for (int i = 0; i < m; i++) {
			Vertex a = v[in.nextInt() - 1];
			Vertex b = v[in.nextInt() - 1];
			a.pq.add(b);
			b.pq.add(a);
		}
		for (int i = 0; i < n; i++) {
			if (v[i].pq.size() < k)
				out.println(-1);
			else {
				int oo = k;
				while (oo-- > 1) {
					v[i].pq.poll();
				}
				out.println((v[i].pq.poll().idx) + 1);
			}
		}
		out.println(System.currentTimeMillis() - curTime + "ms");
		out.close();
	}
}

class Vertex {
	int val;
	int idx;
	PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(new Comparator<Vertex>() {
		@Override
		public int compare(Vertex o1, Vertex o2) {
			if (o1.val < o2.val)
				return 1;
			else if (o1.val > o2.val)
				return -1;
			else if (o1.idx > o2.idx)
				return -1;
			else if (o1.idx < o2.idx)
				return 1;
			else
				return 0;

		}
	});
}
