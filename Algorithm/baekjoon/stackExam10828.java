package baekjoonStudy;

import java.util.*;

***JAVA »ç¿ë

public class stackExam10828 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			String cmd = sc.next();
			if (cmd.equals("push")) {
				stack.push(Integer.parseInt(sc.next()));
			} else if (cmd.equals("top")) {
				if (stack.empty()) {
					System.out.println("-1");
				} else {
					System.out.println(stack.peek());
				}
			} else if (cmd.equals("size")) {
				System.out.println(stack.size());
			} else if (cmd.equals("empty")) {
				if (stack.empty()) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			} else if (cmd.equals("pop")) {
				if (stack.empty()) {
					System.out.println("-1");
				} else {
					System.out.println(stack.pop());
				}
			}
		}
		sc.close();
	}}

	**HARD CODING**

	public class stackExam {
		static int i = 0;
		static int d[];

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			d = new int[n + 1];
			for (int m = 0; m < n; m++) {
				String command = sc.next();
				if (command.equals("push")) {
					int x = sc.nextInt();
					push(x);
				} else if (command.equals("pop")) {
					System.out.println(pop());
				} else if (command.equals("size")) {
					System.out.println(size());
				} else if (command.equals("empty")) {
					System.out.println(empty());
				} else if (command.equals("top")) {
					System.out.println(top());
				}
			}
			sc.close();
		}

		private static void push(int x) {
			d[i] = x;
			i++;
		}

		private static int pop() {
			if (i == 0)
				return -1;
			else {
				i--;
				return d[i];
			}
		}

		private static int size() {
			return i;
		}

		private static int empty() {
			if (i == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		private static int top() {
			if (i == 0) {
				return -1;
			} else {
				return d[i - 1];
			}
		}
}