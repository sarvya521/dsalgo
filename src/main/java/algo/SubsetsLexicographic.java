package algo;

public class SubsetsLexicographic {
	public static void main(String[] args) {
		String[] set = new String[] { "3", "5", "15"};
		solve(set, 0, "", "");
	}

	public static void solve(String[] set, int i, String subset, String str) {
		if(subset.length() > 0) {
			subset = subset+" "+str;
		} else {
			subset = str;
		}
		if(subset.length() > 0) {
			System.out.println(subset);
		}
		for (; i < set.length; i++) {
			solve(set, i + 1, subset, set[i]); 
		}
	}
}
