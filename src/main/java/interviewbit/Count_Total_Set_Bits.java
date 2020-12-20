package interviewbit;

public class Count_Total_Set_Bits {
    private static final int M = 1000000007;//1e9+7;

    public int solve(int A) {
        int count = 0;
        int sum = 0;

        for (int j = 1; j <= A; j++) {
            int i = 0;
            count = 0;

            while (j >= (1 << i)) {
                int num = j | (1 << i);
                if (num == j) {
                    count++;
                }
                i++;

            }
            sum = (sum % M + count % M) % M;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Count_Total_Set_Bits().solve(3));
    }
}
