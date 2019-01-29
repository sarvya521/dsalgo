package hashing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstRepeatingCharacter {

	static void solve(String[] arr, int t) {
        String s = null;
        int i , j, size = 0;
        LinkedHashMap<Character, Integer> map = null;
        Integer c = null;
        boolean repeatedFound = false;
        for(i = 0; i < t; i++) {
            s = arr[i];
            size = s.length();
            map = new LinkedHashMap<Character, Integer>();
            repeatedFound = false;
            for(j = 0; j < size; j++) {
                Character ch = s.charAt(j);
                c = map.get(ch);
                if(c == null) {
                	map.put(ch, 1);
                } else {
                	map.put(ch, c+1);
                	repeatedFound = true;
                }
            }
            if(repeatedFound) {
            	for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            		if(entry.getValue() > 1) {
            			System.out.println(entry.getKey());
            			break;
            		}
            	}
            } else {
            	System.out.println('.');
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine().trim());
        String[] arr = new String[t];
        for(int i = 0; i < t; i++) {
            arr[i] = in.nextLine().trim();
        }
        in.close();
        solve(arr, t);
    }

}
