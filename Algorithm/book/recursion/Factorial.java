package recursion;

import java.text.ParseException;
import java.util.Scanner;

import junit.framework.TestCase;

public class Factorial extends TestCase {

	public void test() throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력");

		int x = sc.nextInt();
		System.out.println(x + "의 팩토리얼은" + factorial(x) + "이다");

		assertEquals(2, (int) factorial(2));
		assertEquals(6, (int) factorial(3));
		assertEquals(120, (int) factorial(5));
		assertEquals(9.33262154439441E157, factorial(100));
		// assertEquals(0, factorial(1990)); 범위초과
	}

	static double factorial(int n) {
		if (n > 0)
			return n * factorial(n - 1);
		else
			return 1;
	}

}
