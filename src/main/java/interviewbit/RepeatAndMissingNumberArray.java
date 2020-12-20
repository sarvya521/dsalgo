package interviewbit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class RepeatAndMissingNumberArray {

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int n = A.size();
        ArrayList<Integer> C = new ArrayList<Integer>();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < A.size(); i++) {
            arr[A.get(i)]++;
        }

        int A1 = 0, B = 0;
        for (int i = 1; i < n + 1; i++) {
            if (arr[i] > 1) {
                A1 = i;
            }
            if (arr[i] == 0) {
                B = i;
            }
        }
        C.add(A1);
        C.add(B);
        return C;
    }
}
