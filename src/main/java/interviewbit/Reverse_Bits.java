package interviewbit;

public class Reverse_Bits {
    public static long reverse(long a) {
        long result = 0;
        int i = 31;
        while(a > 0){
            result += (a % 2) * Math.pow(2, i);
            i--;
            a = a/2;
        }
        return result;
    }
}
