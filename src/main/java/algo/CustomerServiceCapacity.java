package algo;

import java.util.Collection;
import java.util.TreeMap;

public class CustomerServiceCapacity {
	
	static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < callsTimes.length; i++) {
            int a = callsTimes[i][0];
            int b = callsTimes[i][1];
            if(map.containsKey(a)) {
                map.put(a, map.get(a)+1);
            } else {
                map.put(a, 1);
            }
            
            if(map.containsKey(b)) {
                map.put(b, map.get(b)-1);
            } else {
                map.put(b, -1);
            }
        }

        int max = 0;
        int n = 0;
        Collection<Integer> vals = map.values();
        for(Integer v : vals) {
            n = n + v;
            if(max < n) {
                max = n;
            }
        }
        return max - noOfCurrentAgents;
    }
	public static void main(String[] args) {
		int numOfAgent = 1;
		int[][] callsTimes = new int[3][];

        callsTimes[0] = new int[2];
        callsTimes[0][0] = 1481222000;
        callsTimes[0][1] = 1481222020;
        
        callsTimes[1] = new int[2];
        callsTimes[1][0] = 1481222000;
        callsTimes[1][1] = 1481222040;
        
        callsTimes[2] = new int[2];
        callsTimes[2][0] = 1481222030;
        callsTimes[2][1] = 1481222035;

        System.out.println(howManyAgentsToAdd(numOfAgent, callsTimes));
	}
}
