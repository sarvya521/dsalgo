package algo.bitwise;

public class MissingNo {

	static int getMissingNo (int a[]) {
		int n = a.length;
        int i;
        int x = a[0]; 
        int y = 1; 
         
        for (i = 1; i< n; i++) {
            x = x^a[i];
        }
                 
        for (i = 2; i <= n+1; i++) {
            y = y^i;
        }
         
        return (x^y);
    }
      
    public static void main(String args[]) {
        int a[] = {1, 3, 6, 4, 1, 2};
        int miss = getMissingNo(a);
        System.out.println(miss);
    }
}
