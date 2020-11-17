package algo.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/*
We know, you all like Games !! 

Let's Play A Game - Free Falling Footballs. 
In this game, a number of footballs are falling on a infinite sized flat football field, one by one. 
The ball falls on a specified axis without any deviation on the path. 

Let's consider the following scenarios:
Suppose a ball A lands on top of another ball B, one of the following things can happen: 
O, B - existing balls, A - current falling ball

Scenario #1[No slide]: 
 A     .A. 
OBO	-> OBO 

Scenario #2[Slides to right]: 
 A      
OB -> OBA 

Scenario #3[Slides to left]: 
A 
BO -> ABO 

Scenario #4[Slides to right when both left/right positions are vacant]: 
A 
B -> BA 

So, a ball slides according to one of the above scenarios. 
Each time, a ball slides down, it will continue to slide until it's in a place, where it cannot slide any further, 
ie, it does not fall in any of the scenarios #2,#3,#4. 

Input Format

First line of input contains T - number of test cases. 
Its followed by 2T lines, the first line contains N - number of footballs falling on the ground. 
Second line contains N numbers - the positions at which a football falls. 

Constraints

1 <= T <= 500 
1 <= N <= 50 
0 <= P <= 20 

Output Format

For each test case, print the test case number, followed by the final position of the footballs, separated by new line. 
Denote each football by 'O' and each empty slot by '.' 

Sample Input 0

3
4
0 1 2 1 
5
0 1 2 1 1 
6
0 0 0 20 20 20 

Sample Output 0

Case 1:
.O.
OOO
Case 2:
.O..
OOOO
Case 3:
OOO.................OOO
 */
public class FallingFootball {
	
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
            int start = list.get(0).indexOf("O");
            while(iter.hasPrevious()) {
                StringBuilder sb = iter.previous();
                if(start == 0) {
                    System.out.println(sb);
                } else {
                    System.out.println(sb.substring(start));
                }
            }
		}
		in.close();*/
    	StringBuilder ground = new StringBuilder(".");
    	List<StringBuilder> list = new ArrayList<StringBuilder>();
    	list.add(ground);
    	//fall(list, new int[]{0,0,0,0,0,0,0,0,0,0}, 0, 0, 0);
    	//fall(list, new int[]{20, 20, 20, 20, 0, 0, 0}, 0, 0, 0);
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
	}
}
