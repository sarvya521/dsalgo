package ds.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class SlidingWindowMaximum {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        if (A.isEmpty() || B == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < A.size(); i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - B) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && A.get(deque.peekLast()) < A.get(i)) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= B - 1) {
                list.add(A.get(deque.peekFirst()));
            }
        }
        return list;
    }
}
