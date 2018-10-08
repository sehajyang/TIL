package daily;

import java.util.Scanner;

public class main10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int in = sc.nextInt();
		int[][] arr = new int[w + 1][h + 1];
		int count = 0;

		for (int i = 1; i <= w; i++) {
			for (int j = 1; j <= h; j++) {
				arr[i][j] = j * 100 + i;
				count++;
				if (count == in) {
					System.out.println(arr[i][j] + " ");
					break;
				}
			}
		}
	}
}
