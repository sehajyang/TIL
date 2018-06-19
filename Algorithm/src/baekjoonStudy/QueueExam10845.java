package baekjoonStudy;

import java.util.Scanner;

public class QueueExam10845 {
	//¹Ì¿Ï
	static int i = 0;
	static int d[];
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[n + 1];
		for (int i = 0; i < n; i++) {
			String command = sc.next();
			if(command.equals("push")) {
				int x = sc.nextInt();
				push(x);
			}else if(command.equals("pop")) {
				System.out.println(pop());
			}else if(command.equals("push")) {
				System.out.println(size());
			}else if(command.equals("size")) {
				System.out.println(empty());
			}else if(command.equals("front")) {
				System.out.println(front());
			}else if(command.equals("back")) {
				System.out.println(back());
			}
			
		}
		sc.close();
		
	}
	
	private static int front() {
		if (i == 0) {
			return -1;
		} else {
			return d[i - 1];
		}
	}
	
	private static int  back() {
		return d[0];
	}
	
	private static int empty() {
		if(i == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	private static int size() {
		return i;
	}
	
	private static int pop() {
		if (i == 0) {
			return -1;
		}else {
			i =0;
			d[i] = d[i+1];
			return d[i];
		}
	}

	private static void push(int x) {
		d[i] = x;
		i++;
	}
}
