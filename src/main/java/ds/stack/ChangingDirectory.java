package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ChangingDirectory {
	
	static enum Operations {
		cd, pwd
    }
	
	static List<String[]> queries = new ArrayList<String[]>();
	
	static void changeDir(Stack<String> stack, String newDir) {
		if(stack.peek().equals(newDir)) {
			return;
		} else if(newDir.equals("/")) {
			stack.clear();
			stack.push("/");
		}
		String[] arr = newDir.split("/");
		String dir = null;
		boolean traverseCurrentDir = newDir.charAt(0) != '/';
		for(int i = 0; i < arr.length; i++) {
			dir = arr[i];
			if(dir.isEmpty()) {
				continue;
			}
			if(dir.equals("..")) {
				stack.pop();
			} else if(traverseCurrentDir) {
				newDir = stack.peek()+dir+"/";
				stack.push(newDir);
			} else {
				dir = "/"+dir+"/";
				while(stack.peek().indexOf(dir) == 0) {
					stack.pop();
				}
				stack.push(dir);
				traverseCurrentDir = true;
			}
		}
	}
	
	static void showDir(Stack<String> stack) {
		System.out.println(stack.peek());
	}

	static void solve(String[] arr) {
		Stack<String> stack = new Stack<String>();
		stack.add("/");
		String[] command = null;
		for(String com: arr) {
			command = com.split(" ");
			Operations operation = Operations.valueOf(command[0]);
			switch(operation) {
			case cd:
				changeDir(stack, command[1]);
				break;
			case pwd:
				showDir(stack);
				break;
			}
		}
	}
	
	static void solve() {
		for(String[] arr : queries) {
			solve(arr);
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		int i, j;
		String[] commands = null;
		for(i = 0; i < t; i++) {
			int coms = Integer.parseInt(input.readLine());
			commands = new String[coms];
			for(j = 0; j < coms; j++) {
				commands[j] = input.readLine().trim();
			}
			queries.add(commands);
		}
		input.close();
		solve();
	}
}
