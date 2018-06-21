package baekjoonStudy;

public class Main {
	public static void main(String[] args) {
		String str = "Baekjoon Online Judge111";
		char ch[] = str.toCharArray();
		for (int j = 0; j < ch.length; j++) {
			int x = (int) ch[j];
			if (x >= 65 && x <= 91) {
				x += 13;
				if (x > 90) {
					x -= 13;
				}
			} else if (x >= 97 && x <= 122) {
				x += 13;
				if (x > 122) {
					x -= 13;
				}
			}else {
				x = (int) ch[j];
			}
			System.out.println((char) x);
		}

	}
}
