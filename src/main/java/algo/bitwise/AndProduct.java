package algo.bitwise;

public class AndProduct {
    static long andProduct(long a, long b) {
        long x = a ^ b;
        x |= (x >> 1);
        x |= (x >> 2);
        x |= (x >> 4);
        x |= (x >> 8);
        x |= (x >> 16);
        return a & ~x;
    }

    public static void main(String[] args) {
        System.out.println(andProduct(17,23));
        System.out.println(andProduct(11,15));
    }
}
