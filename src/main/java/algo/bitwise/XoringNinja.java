package algo.bitwise;

public class XoringNinja {
    private static final int MOD = 1000000007;

    private static int powMod(int b, int p, final int m){
        int v = 1;
        while(p > 0){
            if ((p & 1) == 1){
                v = (int)((1L*v*b) % m);
            }
            p >>= 1;
            b = (int)((1L*b*b) % m);
        }
        return v;
    }

    static int xoringNinja(int[] arr) {
        int n = arr.length;

        //Get set bits
        int bits = 0;
        for(int i = 0; i < n; i++){
            bits |= arr[i];
        }

        //Get xorSum
        int xorSum = 0;
        final int x = powMod(2, n-1, MOD);
        for(byte i = 0; bits > 0; i++){
            if((bits & 1) == 1){
                xorSum = (int)((xorSum + (((long)x) << i)) % MOD);
            }
            bits >>= 1;
        }
        return xorSum;
    }

    public static void main(String[] args) {
        System.out.println(xoringNinja(new int[]{1, 2, 4, 8}));
        System.out.println(xoringNinja(new int[]{1, 2, 3, 5, 100}));
    }
}
