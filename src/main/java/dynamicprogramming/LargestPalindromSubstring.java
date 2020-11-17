package dynamicprogramming;

public class LargestPalindromSubstring {
	static char[] preprocess(String s) {
        char[] t = new char[s.length()*2 + 3];
        t[0] = '$';
        t[s.length()*2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2*i + 1] = '#';
            t[2*i + 2] = s.charAt(i);
        }
        t[s.length()*2 + 1] = '#';
        return t;
    }
    
    static int solve(String s) {
        char[] t = preprocess(s);
        int[]  p = new int[t.length];
        
        int center = 0, right = 0;
        for (int i = 1; i < t.length-1; i++) {
            int mirror = 2*center - i;

            if (right > i)
                p[i] = Math.min(right - i, p[mirror]);
 
            // attempt to expand palindrome centered at i
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
                p[i]++;
 
            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        
        int length = 0;   // length of longest palindromic substring
        int c = 0;   // center of longest palindromic substring
        for (int i = 1; i < p.length-1; i++) {
            if (p[i] > length) {
                length = p[i];
                c = i;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new String(preprocess("aba")));
    }
}
