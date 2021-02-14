package interviewbit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author sarvesh
 * @since
 */
public class SimplifyDirectoryPath {
    public static String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        final String[] arr = A.split("/");
        for(String str : arr) {
            if("..".equals(str)) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(!".".equals(str) && !str.isEmpty()) {
                stack.push(str);
            }
        }
        Stack<String> revst = new Stack<>();
        while(!stack.isEmpty()) {
            revst.push(stack.pop());
        }
        StringBuilder builder = new StringBuilder();
        while(!revst.isEmpty()) {
            builder.append("/").append(revst.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) throws Exception{
        try (BufferedReader input = new BufferedReader (new InputStreamReader(System.in))) {
            System.out.println(simplifyPath(input.readLine()));
        }
    }
}
