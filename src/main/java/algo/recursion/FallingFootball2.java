package algo.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class FallingFootball2 {
	
	static void fall(List<StringBuilder> groundList, int[] footballs, int index, int currentLevel, int maxLevel) {
		if(index == footballs.length) {
			return;
		}
		int fallIndex = footballs[index];
		StringBuilder level = groundList.get(currentLevel);
		if(fallIndex > level.length() - 1) {
			for(int i = 0; i < groundList.size(); i++) {
				StringBuilder ground = groundList.get(i);
				for(int j = ground.length() ; j <= fallIndex; j++) {
					ground.append(".");
				}
			}
			groundList.get(0).setCharAt(fallIndex, 'O');
			index = index + 1;
			currentLevel = maxLevel;
		} else if(level.charAt(fallIndex) == '.') {
			if(currentLevel != 0) {
				currentLevel = currentLevel - 1;
			} else {
				level.setCharAt(fallIndex, 'O');
				index = index + 1;
				currentLevel = maxLevel;
			}
		} else if(level.charAt(fallIndex) == 'O') {
			if(fallIndex == 0) {
				if(level.length() > 1) {
					if(level.charAt(1) == '.') {
						level.setCharAt(1, 'O');
						index = index + 1;
						currentLevel = maxLevel;
					} else {
						level = new StringBuilder("O").append(level.toString());
						groundList.set(currentLevel, level);
						index = index + 1;
						for(int i = index; i < footballs.length; i++) {
							footballs[i] = footballs[i]+1;
						}
						currentLevel = maxLevel;
						
						for(int i = 1; i < groundList.size(); i++) {
							StringBuilder ground = groundList.get(i);
							if(ground.length() < level.length()) {
								ground = new StringBuilder(".").append(ground.toString());
								groundList.set(i, ground);
							}
						}
					}
				} else {
					level.append('O');
					index = index + 1;
					currentLevel = maxLevel;
				}
			} else if(fallIndex == level.length() - 1) {
				int l = currentLevel + 1;
				while(l < groundList.size()) {
					groundList.get(l).append('.');
					l++;
				}
				level.append('O');
				index = index + 1;
				currentLevel = maxLevel;
			} else if(level.charAt(fallIndex - 1) == 'O' && level.charAt(fallIndex + 1) == 'O') {
				if(currentLevel == maxLevel) {
					StringBuilder newLevel = new StringBuilder(level.toString().replace('O', '.'));
					newLevel.setCharAt(fallIndex, 'O');
					groundList.add(newLevel);
					maxLevel = maxLevel + 1;
					currentLevel = maxLevel;
					index = index + 1;
				} else {
					groundList.get(currentLevel + 1).setCharAt(fallIndex, 'O');
					index = index + 1;
					currentLevel = maxLevel;
				}
			} else {
				if((level.charAt(fallIndex - 1) == 'O' && level.charAt(fallIndex + 1) == '.')
						|| (level.charAt(fallIndex - 1) == '.' && level.charAt(fallIndex + 1) == '.')) {
					if(currentLevel != 0) {
						footballs[index] = fallIndex + 1;
					} else {
						level.setCharAt(fallIndex + 1, 'O');
						index = index + 1;
						currentLevel = maxLevel;
					}
				} else if(level.charAt(fallIndex - 1) == '.' && level.charAt(fallIndex + 1) == 'O') {
					if(currentLevel != 0) {
						footballs[index] = fallIndex - 1;
					} else {
						level.setCharAt(fallIndex - 1, 'O');
						index = index + 1;
						currentLevel = maxLevel;
					}
				}
			}
		}
		fall(groundList, footballs, index, currentLevel, maxLevel);
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
    	StringBuilder ground = new StringBuilder(".");
    	List<StringBuilder> list = new ArrayList<StringBuilder>();
    	list.add(ground);
    	//fall(list, new int[]{0,0,0,0,0,0,0,0,0,0}, 0, 0, 0);
    	fall(list, new int[]{20,20,20,20,20,20,20}, 0, 0, 0);
    	ListIterator<StringBuilder> iter = list.listIterator(list.size());
    	while(iter.hasPrevious()) {
    		StringBuilder sb = iter.previous();
    		System.out.println(sb);
    	}
    	System.out.println("\n");
    	iter = list.listIterator(list.size());
    	int start = list.get(0).indexOf("O");
    	while(iter.hasPrevious()) {
    		StringBuilder sb = iter.previous();
    		if(start == 0) {
            	System.out.println(sb);
            } else {
            	System.out.println(sb.substring(start));
            }
    	}
    	/*
    	..O...
    	.OOO..
    	OOOOOO*/
	}
}
