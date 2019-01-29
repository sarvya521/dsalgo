package string;

public class PhoneNumberFormatter {
	
	static String solve(String s) {
		StringBuilder builder = new StringBuilder();
		s = s.replaceAll("\\s+", "").replaceAll("-", "");
		char[] arr = s.toCharArray();
		int n = arr.length;
		int blockOfThree = n / 3;
		int blockOfTwo = n % 3;
		int cnt = 0;
		for(int i = 0; i < n && cnt < blockOfThree; i++) {
			builder.append(arr[i]);
			if(i % 3 == 2) {
				builder.append("-");
				cnt++;
			}
		}
		if(blockOfTwo == 2) {
			builder.append(arr[n-2]).append(arr[n-1]);
		} else if(blockOfTwo == 1) {
			builder.deleteCharAt(builder.length()-2);
			builder.append(arr[n-2]).append(arr[n-1]);
		} else if(builder.length() > 2){
			builder.deleteCharAt(builder.length()-1);
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		System.out.println(solve("    ----    "));
	}

}
