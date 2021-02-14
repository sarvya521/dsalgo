package ds.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author sarvesh
 * @since
 */
public class Maxspprod {
    static final int P = (int)1e9+7;
    public int maxSpecialProduct(ArrayList<Integer> A) {
        if (A.size() == 1)
            return 0;

        if (A.size() == 2) {
            return 0;
        }

        long[] prods = new long[A.size()];
        Stack<Integer> s1 = new Stack<>();

        s1.push(0);
        for (int i = 1; i < A.size(); i++) {
            while (!s1.empty() && A.get(s1.peek()) <= A.get(i)) {
                s1.pop();
            }
            if (s1.empty()) {
                s1.push(i);
            } else {
                prods[i] = s1.peek();
                prods[i] %= P;
                s1.push(i);
            }
        }

        Stack<Integer> s2 = new Stack<>();

        s2.push(A.size()-1);
        for (int i = A.size()-1; i >= 0; i--) {
            while (!s2.empty() && A.get(s2.peek()) <= A.get(i)) {
                s2.pop();
            }
            if (s2.empty()) {
                s2.push(i);
                prods[i] = 0;
            } else {
                prods[i] *= (s2.peek() % P);
                s2.push(i);
            }
        }

        long max = 0;
        for (int i = 0; i < A.size(); i++) {
            if (prods[i] > max) {
                max = prods[i];
            }
        }

        return (int)(max % P);
    }
}
