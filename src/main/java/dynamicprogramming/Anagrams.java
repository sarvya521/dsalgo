package dynamicprogramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Anagrams {

	static final String T = "True";
    static final String F = "False";
    static int NO_OF_CHARS = 256;
    
    static boolean areAnagram(char str1[], char str2[])
    {
        // Create 2 count arrays and initialize
        // all values as 0
        int count1[] = new int [NO_OF_CHARS];
        Arrays.fill(count1, 0);
        int count2[] = new int [NO_OF_CHARS];
        Arrays.fill(count2, 0);
        int i;
  
        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (i = 0; i <str1.length && i < str2.length; i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }
  
        // If both strings are of different length.
        // Removing this condition will make the program 
        // fail for strings like "aaca" and "aca"
        if (str1.length != str2.length)
            return false;
  
        // Compare count arrays
        for (i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return false;
  
        return true;
    }
    
    static void solve(String[] arr, int t) {
        StringBuilder builder = new StringBuilder("");
        Map<Character, Integer> map1 = null;
        Map<Character, Integer> map2 = null;
        int i,j,n,m,s1,s2;
        String w1, w2;
        Character ch;
        Integer c;
        main:
        for(i = 0; i < t; i++) {
            String[] words = arr[i].split(" ");
            w1 = words[0];
            n = w1.length();
            
            w2 = words[1];
            m = w2.length();
            
            if(n != m) {
                builder.append(F).append("\n");
                continue;
            } else if(w1.equals(w2)) {
            	builder.append(T).append("\n");
                continue;
            }
            
            map1 = new HashMap<Character, Integer>();
            for(j = 0; j < n; j++) {
            	ch = w1.charAt(j);
            	c = map1.get(ch);
            	if(c != null) {
            		map1.put(ch, c+1);
            	} else {
            		map1.put(ch, 1);
            	}
            }
            
            map2 = new HashMap<Character, Integer>();
            for(j = 0; j < m; j++) {
            	ch = w2.charAt(j);
            	c = map2.get(ch);
            	if(c != null) {
            		map2.put(ch, c+1);
            	} else {
            		map2.put(ch, 1);
            	}
            }
            
            s1 = map1.size(); 
            s2 = map2.size();
            if(s1 != s2) {
                builder.append(F).append("\n");
            } else {
	            for(Map.Entry<Character, Integer> entry : map1.entrySet()) {
	            	c = entry.getValue();
	            	if(c != map2.get(entry.getKey())) {
	            		builder.append(F).append("\n");
	            		continue main;
	            	}
	            }
	            builder.append(T).append("\n");
            }
        }
        System.out.println(builder);
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine().trim());
        String[] arr = new String[t];
        for(int i = 0; i < t; i++) {
            arr[i] = in.nextLine().trim().toLowerCase();
        }
        in.close();
        solve(arr, t);*/
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('a', 1);
        map.put('b', 0);
        map.put('c', 0);

        Set<Integer> col = new HashSet<Integer>(map.values());
        col.remove(0);
        System.out.println(col);
    }
    
}
