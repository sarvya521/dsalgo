import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BookingSolution {
	
	static int[] sort_hotels(String keywords, int[] hotel_ids, String[] reviews) {
		keywords = keywords.toLowerCase();
		Map<Integer, Integer> map = new HashMap<>(); 
        String[] keywordsArr = keywords.split(" ");
        int n = hotel_ids.length;
        for(int i = 0; i < n; i++) {
        	int hotelId = hotel_ids[i];
        	String review = reviews[i];
        	review = review.toLowerCase();
        	int wordCount = wordCount(review, keywordsArr);
        	if(map.containsKey(hotelId)) {
        		map.put(hotelId, map.get(hotelId)+wordCount);
        	} else {
        		map.put(hotelId, wordCount);
        	}
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		});
		int[] op = new int[map.size()];
		int i = 0;
		for(Map.Entry<Integer, Integer> entry: list) {
			op[i] = entry.getKey();
			i++;
		}
		return op;
    }
	
	static int wordCount(String review, String[] keywordsArr) {
		int count = 0;
		for(String keyword : keywordsArr) {
			int fromIndex = 0;
			while(fromIndex <= keyword.length()) {
				int idx = review.indexOf(keyword, fromIndex);
				if(idx != -1) {
					count++;
					fromIndex = idx+keyword.length();
				} else {
					break;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String keywords = "breakfast beach citycenter location metro view staff price";
		int[] hotel_ids = new int[]{1, 2, 1, 1, 2};
		String[] reviews = new String[]{"This hotel has a nice view of the citycenter. The location is perfect.", "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.","Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.","They said I couldn't take my dog and there were other guests with dogs! That is not fair.","Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."};
		int[] op = sort_hotels(keywords, hotel_ids, reviews);
		System.out.println(Arrays.stream(op).boxed().collect(Collectors.toList()));
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Collection<Integer> vals = map.values();
		
	}

}
