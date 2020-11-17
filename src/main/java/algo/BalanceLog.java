package algo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.math.*;

public class BalanceLog {
	
	public static int demo(int[] a) {
		System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
		
		int[] coms = new int[a.length];
		coms[0] = a[0];
		for(int i = 1; i < a.length; i++) {
			coms[i] = a[i] + coms[i-1];
		}
		System.out.println(Arrays.stream(coms).boxed().collect(Collectors.toList()));
		int total = coms[a.length-1];
		int lo = 0;
		int hi = a.length;
		int mid;
		while(lo <= hi) {
			mid = lo+(hi-lo)/2;
			if(coms[mid-1] == total-coms[mid]) {
				return mid;
			} else if(coms[mid-1] < total-coms[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}
	
	public static int BalanceBest(int[] a)
	{
		System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
		int leftSum = a[0];
		int rightSum = 0;;
		for(int i=0; i<a.length;i++)//notice we start from 2nd as 1st value is set
			rightSum += a[i];//each sum is sum of previous sum plus current value
		
		for(int i=0; i<a.length-1;i++)
		{
			System.out.println(i+"\t"+leftSum+"\t"+rightSum);
			if(leftSum==rightSum)
				return i;
			leftSum+=a[i+1];
			rightSum-=a[i];
		}
		return -1;//otherwise we return -1 as not found
	}
	
	//now we implement the improved method, using extra memory to achieve o(n) time performance
	public static int BalanceImprove(int[] a)
	{
		//as we discussed we need two extra arrays to store the sums from left to right and from right to left
		int[] leftSums = new int[a.length];
		int[] rightSums = new int[a.length];
		//now we compute sums for leftSums, but as each sum is depending on previous sum, we need assign the 1st sum to a[0]
		leftSums[0] = a[0];
		for(int i=1; i<a.length;i++)//notice we start from 2nd as 1st value is set
			leftSums[i] = leftSums[i-1]+a[i];//each sum is sum of previous sum plus current value
		
		//similarly we set right sums
		rightSums[a.length-1] = a[a.length-1];//we proceed from right to left for right sums
		for(int i=a.length-2;i>=0; i--)
			rightSums[i] = rightSums[i+1]+a[i];
		
		//now compare each value in left and right sum arrays to find match
		for(int i=0; i<leftSums.length;i++)
		{
			if(leftSums[i]==rightSums[i])
				return i;//return immediately when we find a match for balance point
		}
		return -1;//otherwise we return -1 as not found
	}
	
	//firstly let's implement the naive method
	//we return the balance index if found or -1 if not found
	public static int BalanceNaive(int[] a)
	{
		for(int i=0; i<a.length;i++)
		{
			//for each position, we compute left sum and right sum and compare, return if found equal left/right sum
			int leftSum = 0;
			int rightSum = 0;
			for(int m=0; m<=i; m++)
				leftSum+=a[m];
			for(int m=i; m<a.length;m++)
				rightSum+=a[m];
			if(leftSum==rightSum)
				return i;//index returned whenever equal left/right found
		}
		return -1;//if no return before that means no balance point found
	}
	
	public double balancePoint(Log log) {
		 int len = (int)log.length();
		 int lo = 0;
		 int hi = len;
		 int mid;
		 double w1, w2, total;
		 total = log.weightUpto(len);
		 total = Math.round(total*1000)/1000.000d;
		 System.out.println("total="+total);
		 while(lo <= hi) {
			 mid = lo+(hi-lo)/2;
			 w1 = log.weightUpto(mid);
			 w1 = Math.round(w1*1000)/1000.000d;
			 
			 w2 = log.weightUpto(mid-1);
			 w2 = Math.round(w2*1000)/1000.000d;
			 
			 if(w2 == total-w1) {
				return mid;
			} else if(w2 < total-w1) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		 }
		 return 0;
	}

	// DO NOT MODIFY CODE BELOW THIS LINE
	interface Log {
            double weightUpto(double x); // returns the weightUpto of the part of the log from the left end to a point at distance x from it.
            double length(); // returns the total length of the log
	}

	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] tokens = line.split(" ");
			Log c = null;
			switch (tokens[0]) {
			case "LINE":
				c = new Line(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
						Double.parseDouble(tokens[3]));
				break;
			case "EXP":
				c = new Exp(Double.parseDouble(tokens[1]));
				break;
			case "POWER":
				c = new Power(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
				break;
			case "SINE":
				c = new Sine(Double.parseDouble(tokens[1]));
				break;
			}

			if (c == null) {
				break;
			}
			BalanceLog t = new BalanceLog();
			double h = t.balancePoint(c);
			System.out.println(Math.round(h * 1000d));
		}

		scanner.close();*/
		
		int[] a = {1,2,3,7,6,5,9,5,6,7,5,2,-1};//expected 6th position
		System.out.println("(Naive) Balance point for a is index "+BalanceNaive(a));
		System.out.println("(Improve) Balance point for a is index "+BalanceImprove(a));
		System.out.println("(Best) Balance point for a is index "+BalanceBest(a));
		
		System.out.println("Binary "+demo(a));
		
		Log c = new Line(Double.parseDouble("20"), Double.parseDouble("5"), Double.parseDouble("10"));
		BalanceLog t = new BalanceLog();
		double h = t.balancePoint(c);
		System.out.println("h="+h);
	}

	static class Line implements Log {
		private double m;
		private double c;
		private double l;

		public Line(double l, double m, double c) {
			this.m = m;
			this.c = c;
			this.l = l;
		}

		@Override
		public double weightUpto(double x) {
			return m * x + c;
		}

		@Override
		public double length() {
			return l;
		}
	}

	static class Exp implements Log {
		private double l;

		public Exp(double l) {
			this.l = l;
		}

		@Override
		public double weightUpto(double x) {
			if (x < 0) {
				return 0;
			} else if (x > l) {
				return Math.exp(l);
			}
			return Math.exp(x);
		}

		@Override
		public double length() {
			return l;
		}
	}

	static class Power implements Log {
		private double l;
		private double power;

		public Power(double l, double power) {
			this.l = l;
			this.power = power;
		}

		@Override
		public double length() {
			return l;
		}

		@Override
		public double weightUpto(double x) {
			if (x < 0) {
				return 0;
			} else if (x > l) {
				return Math.pow(l, power);
			} else {
				return Math.pow(x, power);
			}
		}
	}

	static class Sine implements Log {
		private double l;

		public Sine(double l) {
			this.l = l;
		}

		@Override
		public double length() {
			return l;
		}

		@Override
		public double weightUpto(double x) {
			if (x < 0) {
				return 0;
			} else if (x > l) {
				return l + Math.sin(l);
			} else {
				return x + Math.sin(x);
			}
		}
	}
}