import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
	
	static long[] prefixSum(int[] arr) {
		int n = arr.length;
		long[] coms = new long[n+1];
		coms[0] = 0;
		for(int i = 1; i <= n; i++) {
			coms[i] = coms[i-1] + arr[i-1];
		}
		return coms;
	}
	
	public static int findArray(int[] array, int[] subArray) {
		if(array == null || subArray == null || array.length < subArray.length) {
			return -1;
		}
		
		System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
		System.out.println(Arrays.stream(subArray).boxed().collect(Collectors.toList()));
		
		int n = array.length;
		int m = subArray.length;
		
		long[] arrayComs = prefixSum(array);
		long[] subArrayComs = prefixSum(subArray);
		System.out.println(Arrays.stream(arrayComs).boxed().collect(Collectors.toList()));
		System.out.println(Arrays.stream(subArrayComs).boxed().collect(Collectors.toList()));
		
		long totalSubArraySum = subArrayComs[m-1];
		
		long a = 0;
		int i, j, idx = -1;
		for(i = m; i <= n; i++) {
			a = arrayComs[i] - arrayComs[i-m];
			if(a >= totalSubArraySum) {
				for(j = 0; j < m; j++) {
					if(subArray[j] != array[i-m+j]) {
						break;
					}
				}
				if(j == m) {
					idx = i-m;
				}
			}
		}
		return idx;
	}
	
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
		//System.out.println(findArray(new int[]{3, 5, 1, 8, 2, 1, 8, 2, 1}, new int[]{8,2,1,2}));
		//System.out.println(decode("one=1&two=2&=3&=4&three=&="));
		//System.out.println();
	}
	
	private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = i; j < arr.length; j++) {
                builder.append(arr[j] + " ");
                System.out.println(builder.toString());
            }
        }
    }
    
    private static void generate(int[] arr) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> innerList = null;
            for (int j = i; j < arr.length; j++) {
                innerList = new ArrayList<Integer>();
                for (int k = i; k <= j; k++) {
                    innerList.add(arr[k]);
                }
                list.add(innerList);
            }
            
        }
        
        for(List<Integer> li : list) {
            for(Integer num : li) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
