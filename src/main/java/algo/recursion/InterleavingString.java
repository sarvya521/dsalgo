package algo.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InterleavingString {

	static void interleave(String a, int p1, String b, int p2, char[] arr, List<String> list, int m ,int n, int i) {
		if(m == 0 && n == 0) {
			list.add(new String(arr));
		}
		if(m != 0) {
			arr[i] = a.charAt(p1);
			interleave(a, p1+1, b, p2, arr, list, m-1, n, i+1);
		}
		if(n != 0) {
			arr[i] = b.charAt(p2);
			interleave(a, p1, b, p2+1, arr, list, m, n-1, i+1);
		}
	}
	
	static void sortLexicographically(List<String> list) {
		for(int i = 0; i < list.size() - 1; ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
	}
	
	static void interleave(String str) {
		String[] arr = str.split("\\s+");
		String a = arr[0];
		String b = arr[1];
		int m = a.length();
		int n = b.length();
		char[] op = new char[m+n];
		int p1 = 0;
		int p2 = 0;
		int i = 0;
		List<String> list = new ArrayList<String>();
		interleave(a, p1, b, p2, op, list, m, n, i);
		sortLexicographically(list);
	}
	
	public static void main(String[] args) {
		/*Pattern pattern = Pattern.compile("[a-z]+[\\s][a-z]+");
		String s = "nkb gl";
		System.out.println(pattern.matcher(s).matches());*/
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			String str1 = in.next();
			String str2 = in.next();
			System.out.println("Case #"+(i+1)+":");
			interleave(str1+" "+str2);
		}
		in.close();
		/*String str = "nkb gl";
		interleave(str);*/
	}
	
}
