package algo.array.rearrange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * ccda
 * ccbk
 * cd
 * a
 * ab
 */
public class RearrangeAlphabets {

    private static List<Character> rearrange(String[] words) {
        if(Objects.isNull(words) && words.length < 1) {
            return Collections.emptyList();
        }
        List<Character> list = new ArrayList<>();
        int idx = 0;
        while(true) {
            boolean breakLoop = true;
            for (String word : words) {
                if (word.length() > idx) {
                    breakLoop = false;
                    final char ch = word.charAt(idx);
                    if (!list.contains(ch)) {
                        list.add(ch);
                    }
                }
            }
            if(breakLoop) {
                break;
            }
            idx++;
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words1 = {"ccda", "ccbk", "cd", "a", "ab"};
        System.out.println(rearrange(words1));
        String[] words2 = {"ccc", "dddd", "aaaa"};
        System.out.println(rearrange(words2));
        String[] words3 = {"ccda", "ccb", "a", "ab", "d"};
        System.out.println(rearrange(words3));
    }
}
