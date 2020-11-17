package ds.circularqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KillingDragons {
	
	/*static int solve(LinkedList<Integer> dEnergyList, LinkedList<Integer> vEnergyList) {
		int size = dEnergyList.size();
		int i = 0, j = 0, d, v, dEnergy, vEnergy, savedEnergy = 0;
		int count = 0;
		while(i < size) {
			savedEnergy = 0;
			while(j < size) {
				count++;
				dEnergy = dEnergyList.get(j);
				vEnergy = vEnergyList.get(j) + savedEnergy;
				j++;
				if(vEnergy >= dEnergy) {
					savedEnergy = vEnergy - dEnergy;
					if(j == size) {
						System.out.println(count);
						return i+1;
					}
				} else {
					while(j > 0) {
						d = dEnergyList.pollFirst();
						v = vEnergyList.pollFirst();
						dEnergyList.addLast(d);
						vEnergyList.addLast(v);
						j--;
						i++;
					}
					break;
				}
			}
		}
		System.out.println(count);
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		while(t > 0) {
			LinkedList<Integer> dEnergyList = new LinkedList<Integer>();
			LinkedList<Integer> vEnergyList = new LinkedList<Integer>();
			int n = Integer.parseInt(input.readLine().trim());
			String[] arr1 = input.readLine().trim().split(" ");
			String[] arr2 = input.readLine().trim().split(" ");
			for(int j = 0; j < n; j++) {
				dEnergyList.add(Integer.parseInt(arr1[j]));
				vEnergyList.add(Integer.parseInt(arr2[j]));
			}
            System.out.println(solve(dEnergyList, vEnergyList));
			t--;
		}
		input.close();
	}*/
	
	static int solve(int[] dEnergyList, int[] vEnergyList, int n) {
		if(vEnergyList[n] < dEnergyList[n]) {
			return -1;
		}
		int idx = 1;
		int d = 0;
		int v = 0;
		for(int i = 1; i <= n; i++) {
			if((vEnergyList[i] - v) < (dEnergyList[i] - d)) {
				d = dEnergyList[i];
				v = vEnergyList[i];
				idx = i+1;
			}
		}
		return idx;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		while(t > 0) {
			int n = Integer.parseInt(input.readLine().trim());
			String[] arr1 = input.readLine().trim().split(" ");
			String[] arr2 = input.readLine().trim().split(" ");
			int[] dEnergyList = new int[n+1];
			int[] vEnergyList = new int[n+1];
			dEnergyList[0] = 0;
			vEnergyList[0] = 0;
			for(int j = 1; j <= n; j++) {
				dEnergyList[j] = dEnergyList[j-1] + Integer.parseInt(arr1[j-1]);
				vEnergyList[j] = vEnergyList[j-1] + Integer.parseInt(arr2[j-1]);
			}
			System.out.println(solve(dEnergyList, vEnergyList, n));
			t--;
		}
		input.close();
	}
}