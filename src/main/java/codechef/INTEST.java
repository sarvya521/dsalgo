package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sarvesh
 * @since
 */
public class INTEST {
    private static void solve(int n, int k, List<Long> numbers) {
        final long count = numbers.parallelStream()
                .filter(t -> t % k == 0)
                .count();
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        int n, k;
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] arr = br.readLine().split(" ");
            n = Integer.parseInt(arr[0]);
            k = Integer.parseInt(arr[1]);
            int t = n;
            while(t > 0) {
                lines.add(br.readLine());
                t--;
            }
        }
        solve(n, k, lines.stream().map(Long::parseLong).collect(Collectors.toList()));
    }
}

/*
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;


// Remember that the class name should be "Main" and should be "public".
public class Main {
	public static void main(String[] args) {
		// System.in and System.out are input and output streams, respectively.
		InputStream inputStream = System.in;

		InputReader in = new InputReader(inputStream);

		int n = in.nextInt();
		int k = in.nextInt();

		int ans = 0;

		for (int i = 0; i < n; i++) {
			int x = in.nextInt();

			if (x % k == 0) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
				    tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
				    throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}


 */
