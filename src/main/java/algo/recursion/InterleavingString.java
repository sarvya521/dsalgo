package algo.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
Given 2 strings A and B, print all the interleavings of the 2 strings.
An interleaved string of given two strings preserves the order of characters in individual strings 
and uses all the characters of both the strings. 
For simplicity, you can assume that the strings have unique characters. 

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each contains 2 space separated strings A and B. 

Constraints

1 <= T <= 100 
'a' <= A[i], B[i] <= 'z' 
1 <= len(A), len(B) <= 10 

Output Format

For each test case, 
print the test case number, followed by the interleavings of the 2 strings in a sorted order, separated by newline. 

Sample Input 0

2
nkb gl
bn zh

Sample Output 0

Case #1:
glnkb
gnkbl
gnklb
gnlkb
ngkbl
ngklb
nglkb
nkbgl
nkgbl
nkglb
Case #2:
bnzh
bzhn
bznh
zbhn
zbnh
zhbn
 */
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
		/*Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			String str1 = in.next();
			String str2 = in.next();
			System.out.println("Case #"+(i+1)+":");
			interleave(str1+" "+str2);
		}
		in.close();*/
		String str = "nkb gl";
		interleave(str);
	}
	
}
