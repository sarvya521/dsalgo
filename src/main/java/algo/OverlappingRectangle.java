
public class OverlappingRectangle {
	
	/*
	-2 2 4 4 -3 1 5 5
	*/
	static boolean isOverlap(int a1, int b1, int c1, int d1, int a2, int b2, int c2, int d2)
	{
		int a3 = Math.max(a1, a2);
		int b3 = Math.max(b1, b2);
		
		int width1 = c1-a1;
		int width2 = c2-a2;
		int width3 = Math.min(a1+width1, a2+width2) - a3;
		
		int hieght1 = d1-b1;
		int hieght2 = d2-b2;
		int hieght3 = Math.min(b1+hieght1, b2+hieght2) - b3;
		
		if(width3 < 0 || hieght3 < 0) {
			return false;
		}
	 
	    return true;
	}

	static int solve(int a1, int b1, int c1, int d1, int a2, int b2, int c2, int d2) {
		int area1 = (c1-a1) * (d1-b1);
		int area2 = (c2-a2) * (d2-b2);
		
		System.out.println(isOverlap(a1, b1, c1, d1, a2, b2, c2, d2));
		
		int a3 = Math.max(a1, a2);
		int b3 = Math.max(b1, b2);
		int c3 = Math.min(c1, c2);
		int d3 = Math.min(d1, d2);
		
		int area3 = (c3-a3) * (d3-b3);
		if(area3 > 0) {
			return area1+area2-area3;
		}
		return area1+area2;
	}
	
	public static void main(String[] args) {
		/*int a1 = -4;
		int b1 = -3;
		int c1 = -2;
		int d1 = 5;
		
		int a2 = -3;
		int b2 = -5;
		int c2 = 1;
		int d2 = 3;*/
		/*int a1 = 2;
		int b1 = 5;
		int c1 = 4;
		int d1 = 6;
		
		int a2 = 1;
		int b2 = 2;
		int c2 = 5;
		int d2 = 4;*/
		
		int a1 = -2;
		int b1 = 2;
		int c1 = 4;
		int d1 = 4;
		
		int a2 = -3;
		int b2 = 1;
		int c2 = 5;
		int d2 = 5;
		
		System.out.println(solve(a1, b1, c1, d1, a2, b2, c2, d2));
	}

	/*static long solve(long a1, long b1, long c1, long d1, long a2, long b2, long c2, long d2) {
		long area1 = (c1-a1) * (d1-b1);
		long area2 = (c2-a2) * (d2-b2);
		
		long a3 = Math.max(a1, a2);
		long b3 = Math.max(b1, b2);
		long c3 = Math.min(c1, c2);
		long d3 = Math.min(d1, d2);
		
		long area3 = (c3-a3) * (d3-b3);
		if(area3 > 0) {
			return area1+area2-area3;
		}
		return area1+area2;
	}
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			long a1 = in.nextLong();
            long b1 = in.nextLong();
            long c1 = in.nextLong();
            long d1 = in.nextLong();
            long a2 = in.nextLong();
            long b2 = in.nextLong();
            long c2 = in.nextLong();
            long d2 = in.nextLong();
			System.out.println(solve(a1, b1, c1, d1, a2, b2, c2, d2));
		}
		in.close();
    }*/
}
