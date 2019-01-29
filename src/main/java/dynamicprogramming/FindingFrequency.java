package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindingFrequency {

	static Map<Integer, Integer> map = new HashMap<>();
    /*static void solve(int[] arr, int n, int[] qr, int q) {
        int i;
        int e;
        Integer c;
        for(i = 0; i < n; i++) {
            e = arr[i];
            c = map.get(e);
            if(c != null) {
                map.put(e, c+1);
            } else {
                map.put(e, 1);
            }
        }
        for(i = 0; i < q; i++) {
            System.out.println(map.get(qr[i]));
        }
    }*/
	
	static void solve(int[] arr, int n, int[] qr, int q) {
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
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] arr = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int q = Integer.parseInt(input.readLine());
        int i;
        int e;
        int[] qr = new int[q];
        for(i = 0; i < q; i++) {
            e =  Integer.parseInt(input.readLine());
            qr[i] = e;
            map.put(e, 0);
        }
        input.close();
        solve(arr, n, qr, q);
    }
}
