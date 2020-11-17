package algo.pattern;

/**
 * @author sarvesh
 * @since
 */
public class DiamondPattern {

    private static void printPattern(int n) {
        int mid = n / 2;
        int spaces = 0;
        for(int i = 0; i < n; i++) {
            if(i < mid) {
                spaces = mid - i;
                while(spaces > 0) {
                    System.out.print(" ");
                    spaces --;
                }
                System.out.print("*");
            } else if (i == mid) {
                System.out.print("*");
            } else {
                spaces = i - mid;
                while(spaces > 0) {
                    System.out.print(" ");
                    spaces --;
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPattern(7);
    }
}
