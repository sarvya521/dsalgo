package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindingFrequency {

	/*static void solveBS(int[] arr, int n, int[] qr, int q) {
		Arrays.sort(arr);
		
		int p1 = 0, p2 = 0;
		int lo, hi, mid;
		for(int i = 0; i < q; i++) {
			int e = qr[i];
			p1 = -1;
			p2 = -1;
			lo = 0;
			hi = n;
			while(lo <= hi) {
				mid = lo + (hi-lo) / 2;
				if(arr[mid] == e) {
					p2 = mid;
					for(int j = 1; mid+j < n; j++) {
						if(arr[mid+j] == e) {
							p2 = mid+j;
						} else {
							break;
						}
					}
					p1 = mid;
					for(int j = 1; mid-j >=0 ; j++) {
						if(arr[mid-j] == e) {
							p1 = mid-j;
						} else {
							break;
						}
					}
					break;
				} else if(arr[mid] > e) {
					hi = mid-1;
				} else if(arr[mid] < e) {
					lo = mid+1;
				}
			}
			if(p1 != -1) {
				System.out.println("frequency of "+e+"="+(p2-p1+1));
			} else {
				System.out.println("frequency of "+e+"=0");
			}
		}
    }*/

	static Map<Integer, Integer> map = new HashMap<>();
	static void solveWithHashMap(int[] arr, int n, int[] qr, int q) {
		for(int i = 0; i < n; i++) {
			int e = arr[i];
			//map.merge(e, 1, (v1, v2) -> v1+v2);
			Integer c = map.get(e);
			if(c != null) {
				map.put(e, c+1);
			} else {
				map.put(e, 1);
			}
		}
		for(int i = 0; i < q; i++) {
			System.out.println(map.getOrDefault(qr[i], 0));
		}
	}

	static int BS(int[] arr, int N, int K) {
		int lo=0, hi=N-1;
		while(lo <= hi) {
			int mid = (lo+hi)/2;
			if(arr[mid] == K) {
				return mid;
			} else if(K > arr[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}

	static void solve(int[] arr, int N, int[] qr, int Q, int[] ans) {
		for(int i = 0; i < Q; i++) {
			int q = qr[i];
			int p1 = -1;
			int p2 = -1;
			int lo = 0;
			int hi = N;
			while(lo <= hi) {
				int mid = (lo + hi) / 2;
				if(arr[mid] == q) {
					p1 = -1;
					int j = 0;
					for(j = mid-1; j >= 0; j--) {
						if(arr[j] != q) {
							p1 = j+1;
							break;
						}
					}
					if(j == -1) {
						p1 = 0;
					}
					p2 = -1;
					j = mid+1;
					for(j = mid+1; j < N; j++) {
						if(arr[j] != q) {
							p2 = j-1;
							break;
						}
					}
					if(j == N) {
						p2 = N-1;
					}
					break;
				} else if(arr[mid] > q) {
					hi = mid-1;
				} else if(arr[mid] < q) {
					lo = mid+1;
				}
			}
			if(p1 != -1) {
				ans[i] = p2-p1+1;
			}
		}
	}

	static void solveBS(int[] arr, int N, int[] qr, int Q) {
		Arrays.sort(arr);
		int[] tmp = new int[Q];
		for(int i = 0; i < Q; i++) {
			tmp[i] = qr[i];
		}
		Arrays.sort(qr);
		int[] ans = new int[Q];
		solve(arr, N, qr, Q, ans);
		Arrays.stream(ans).forEach(System.out::println);
		System.out.println("-------------------------------");
		for(int i = 0; i < Q; i++) {
			int k = tmp[i];
			final int index = BS(qr, Q, k);
			System.out.println(ans[index]);
		}
	}

	static int BS1(int[] arr, int N, int K) {
		int lo=0, hi=N-1, ans=-1;
		while(lo <= hi) {
			int mid = (lo+hi)/2;
			if(arr[mid] == K) {
				ans = mid;
				hi = mid - 1;
			} else if(K > arr[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return ans;
	}

	static int BS2(int[] arr, int N, int K) {
		int lo=0, hi=N-1, ans=-1;
		while(lo <= hi) {
			int mid = (lo+hi)/2;
			if(arr[mid] == K) {
				ans = mid;
				lo = mid + 1;
			} else if(K > arr[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return ans;
	}

	static void solveTwoBS(int[] arr, int N, int[] qr, int Q) {
		Arrays.sort(arr);
		for(int i = 0; i < Q; i++) {
			int q = qr[i];
			final int p1 = BS1(arr, N, q);
			final int p2 = BS2(arr, N, q);
			if(p1 == -1) {
				System.out.println(0);
			} else {
				System.out.println(p2 - p1 + 1);
			}
		}
	}

    public static void main(String[] args) throws Exception{
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
			int Q = Integer.parseInt(br.readLine());
			int[] qr = new int[Q];
			for(int i = 0; i < Q; i++) {
				qr[i] = Integer.parseInt(br.readLine());
			}
			solveWithHashMap(arr, N, qr, Q);
			System.out.println("===================================");
			//solveBS(arr, N, qr, Q);
			//System.out.println("===================================");
			solveTwoBS(arr, N, qr, Q);
		}
    }
}
