package interviewbit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author sarvesh
 * @since
 */
public class BalancedParantheses {

    public static int solve(String A) {
        Stack<Character> stack = new Stack<>();
        char[] chars = A.toCharArray();
        for(char ch : chars) {
            if(stack.isEmpty()) {
               stack.push(ch);
            } else {
                char top = stack.peek();
                if(top == '(' && ch == ')') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) throws Exception{
        try (BufferedReader input = new BufferedReader (new InputStreamReader(System.in))) {
            System.out.println(solve(input.readLine()));
        }
    }
}
