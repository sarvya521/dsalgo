package interviewbit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author sarvesh
 * @since
 */
public class RedundantBraces {

    public static int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for (char c : A.toCharArray()) {
            if (c == ')') {
                char top = stack.pop();
                if (top == '(') {
                    return 1;
                }
                else {
                    int count = 0;
                    while (top != '(') {
                        top = stack.pop();
                        count++;
                    }
                    if (count == 1) {
                        return 1;
                    }
                }
            }
            else {
                stack.add(c);
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        try (BufferedReader input = new BufferedReader (new InputStreamReader(System.in))) {
            System.out.println(braces(input.readLine()));
        }
    }
}
