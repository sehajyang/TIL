/*
 * 181012
 * 백준10808
 */

package daily.java;

import java.io.IOException;
import java.util.Scanner;

public class main10808 {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int arrtmp[] = new int[26];
		String str = sc.nextLine();
		
		for (int i = 0; i < str.length(); i++) {
			arrtmp[str.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			System.out.printf(arrtmp[i] + " ");
		}
	}
}