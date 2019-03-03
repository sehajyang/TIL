package baekjoonStudy;

import java.util.*;

public class Main2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int suma = 0;
		int sumb = 0;

		while (a % 5 != 0 && a >= 0) {
			a -= 3;
			sumb++;
		}
		if(a<0) {
			System.out.println("-1");
		}else {
			suma=a/5;
			System.out.println(suma+sumb);
		}

		sc.close();
	}

}
