package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Different_Bits_Sum_Pairwise {
    private static final int M = 1000000007;

    public int cntBits(List<Integer> A) {
        int n = A.size();
        int ans = 0;

        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if((A.get(j) & (1 << i)) == 0){
                    count++;
                }
            }
            ans += (count % M * (n - count) % M * 2) % M;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Different_Bits_Sum_Pairwise().cntBits(Arrays.asList(1, 3, 5)));
    }
}
