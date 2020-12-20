package algo.string;

/**
 * @author sarvesh
 * @since
 */
public class RabinKarp {

    private static final int P = 53;
    private static final int K = (int)1e9+7;

    private static int solve(String B, String A) {
        int c = 0;
        int N = A.length();
        int M = B.length();

        long HA = 0;
        long HB = 0;

        long x = 1;

        for (int i = 0; i < M; i++) {
            x = (x * P) % K;
            HA = (HA + (A.charAt(i) * x)) % K;
            HB = (HB + (B.charAt(i) * x)) % K;
        }

        if(HA == HB) {
            c++;
        }

        long y = 1;
        for(int i = M; i < N; i++) {
            x = (x * P) % K;
            y = (y * P) % K;
            HA = ((HA + (A.charAt(i) * x) % K - (A.charAt(i-M) * y) % K) + K) % K;
            HB = (HB * P) % K;
            if(HA == HB) {
                c++;
            }
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(solve("smart", "yekicmsmartplrplsmartrplplmrpsmartrpsmartwmrmsmartsmart"));
    }
}
