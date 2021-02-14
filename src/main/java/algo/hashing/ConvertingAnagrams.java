package algo.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sarvesh
 * @since
 */
public class ConvertingAnagrams {

    private static int solve(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        for(Character ch : chars) {
            final Integer count = map1.getOrDefault(ch, 0);
            map1.put(ch, count+1);
        }

        chars = s2.toCharArray();
        Map<Character, Integer> map2 = new HashMap<>();
        for(Character ch : chars) {
            final Integer count = map2.getOrDefault(ch, 0);
            map2.put(ch, count+1);
        }

        int count = 0;
        for(Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character ch = entry.getKey();
            Integer freq = entry.getValue();
            if(map2.containsKey(ch)) {
                count = count + Math.abs(freq - map2.get(ch));
            } else {
                count += freq;
            }
        }

        for(Map.Entry<Character, Integer> entry : map2.entrySet()) {
            Character ch = entry.getKey();
            Integer freq = entry.getValue();
            if(!map1.containsKey(ch)) {
                count += freq;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader (new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                String[] input = br.readLine().split(" ");
                builder.append(solve(input[0], input[1])).append(System.lineSeparator());
            }
            System.out.println(builder);
        }
    }
}
