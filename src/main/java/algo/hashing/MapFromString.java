package algo.hashing;

import java.util.HashMap;
import java.util.Map;

public class MapFromString {

	public static Map<String, String> decode(String s) {
		if(s == null) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		if(s.length() == 0) {
			return map;
		}
		if(s.indexOf('=') == -1) {
			throw new IllegalArgumentException();
		}
		String[] arr = s.split("&");
		String[] en = null;
		String k, v;
		for(String entry :  arr) {
			en = entry.split("=");
			k = en.length > 0 ? en[0] : "";
			v = en.length > 1 ? en[1] : "";
			map.put(k, v);
		}
		return map;
	}
	
	public static void main(String[] args) {
		System.out.println(decode("one=1&two=2&=3&=4&three=&="));
	}

}
