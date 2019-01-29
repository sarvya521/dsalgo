package algo.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class FallingFootball {
	
	static void fall(List<StringBuilder> groundList, int[] footballs, int fallIndex, int level, int nextLevel) {
		if(fallIndex == footballs.length) {
			return;
		}
		int index = footballs[fallIndex];
		
		if(groundList.get(level).length() <= index) {
			for(int i = 0; i < groundList.size(); i++) {
				StringBuilder ground = groundList.get(i);
				for(int j = ground.length() ; j <= index; j++) {
					ground.append(".");
				}
			}
			groundList.get(0).setCharAt(index, 'O');
		} else {
			StringBuilder ground = groundList.get(level);
			char ch = ground.charAt(index);
			if(index == groundList.get(0).length()-1) {
				for(int j = groundList.size() - 1; j > 0; j--) {
					groundList.get(j).append(".");
				}
				groundList.get(0).append('O');
			} else {
				if(ch == 'O') {
					if(index == 0) {
						if(ground.length() > 1 && ground.charAt(1) == '.'){
							ground.setCharAt(1, 'O');
						} else {
							if(groundList.size() > 1) {
								for(int j = groundList.size() - 1; j > 0; j--) {
									groundList.set(j, new StringBuilder("."+groundList.get(j)));
								}
							}
							ground.insert(0, Character.valueOf('O'));
							if(ground.length() > 1) {
								for(int i = fallIndex+1; i < footballs.length; i++) {
									footballs[i] = footballs[i]+1;
								}
							}
						}
					} else if(ground.charAt(index - 1) == 'O' && ground.charAt(index + 1) == 'O') {
						if(level < groundList.size() - 1) {
							groundList.get(level+1).setCharAt(index, 'O');
							level = level + 1;
						} else {
							StringBuilder up = new StringBuilder(ground.toString().replace('O', '.'));
							up.setCharAt(index, 'O');
							groundList.add(up);
							level = level + 1;
							nextLevel = level;
						}
					} else if(ground.charAt(index - 1) == '.' && ground.charAt(index + 1) == '.') {
						if(level - 1 >= 0) {
							footballs[fallIndex] = index + 1;
							fall(groundList, footballs, fallIndex, level - 1, nextLevel);
							return;
						}
						ground.setCharAt(index + 1, 'O');
					} else if(ground.charAt(index - 1) == 'O' && ground.charAt(index + 1) == '.'){
						if(level - 1 >= 0) {
							footballs[fallIndex] = index + 1;
							fall(groundList, footballs, fallIndex, level - 1, nextLevel);
							return;
						}
						ground.setCharAt(index + 1, 'O');
					} else if(ground.charAt(index - 1) == '.' && ground.charAt(index + 1) == 'O'){
						if(level - 1 >= 0) {
							footballs[fallIndex] = index - 1;
							fall(groundList, footballs, fallIndex, level - 1, nextLevel);
							return;
						}
						ground.setCharAt(index - 1, 'O');
					}
				} else {
					if(level - 1 >= 0) {
						fall(groundList, footballs, fallIndex, level - 1, nextLevel);
						return;
					} else {
						ground.setCharAt(index, 'O');// ch == '.'
						level = nextLevel;
					}
				}
			}
		}
		fall(groundList, footballs, fallIndex+1, level, nextLevel);
	}
	
    public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
            StringBuilder ground = new StringBuilder("");
    	    List<StringBuilder> list = new ArrayList<StringBuilder>();
    	    list.add(ground);
			fall(list, arr, 0, 0, 0);
            System.out.println("Case "+(i+1)+":");
			ListIterator<StringBuilder> iter = list.listIterator(list.size());
            while(iter.hasPrevious()) {
                StringBuilder sb = iter.previous();
                System.out.println(sb);
            }
		}
		in.close();*/
    	StringBuilder ground = new StringBuilder("");
    	List<StringBuilder> list = new ArrayList<StringBuilder>();
    	list.add(ground);
    	fall(list, new int[]{20, 20, 20, 20, 0, 0, 0}, 0, 0, 0);
    	ListIterator<StringBuilder> iter = list.listIterator(list.size());
    	while(iter.hasPrevious()) {
    		StringBuilder sb = iter.previous();
    		System.out.println(sb);
    	}
    	/*StringBuilder ground = new StringBuilder("OOOOO");
    	ground.insert(0, Character.valueOf('O'));
    	System.out.println(ground);*/
    	//ground.append(".").insert(6, 0).deleteCharAt(ground.length()-1);
    	//ground.insert(0, 0);
	}
}
