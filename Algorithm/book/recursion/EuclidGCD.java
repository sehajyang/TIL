package recursion;

import java.text.ParseException;
import java.util.Scanner;

import junit.framework.TestCase;

public class EuclidGCD extends TestCase {
	public void test() throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("최대공약수 구하기\n정수 두번 입력");
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println("최대공약수는" + gcd(x, y) + "이다");

		assertEquals(2, gcd(12, 2));
		assertEquals(5, gcd(30, 5));
		assertEquals(4, gcd(128, 36));
	}

	static int gcd(int x, int y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}

}
