/*
 * 백준 2292번 벌집
 * 18-10-06
 * 끝숫자에서 처음 숫자를 뺀 수끼리 6씩 차이남
 * 2 ~ 7 => 5
 * 8 ~ 19 => 5 + 6 = 11
 * 20~ 37 => 5 + 6 + 6 = 17
 * 
 * */
package daily.java;

import java.util.Scanner;

public class main2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int start = 0;
		int end = 0;
		int tmp = end - start;
		boolean flag = true;
		int count = 0;
		
		while (flag) {
			tmp += 6;
			start = end + 1;
			end = tmp + start;
			count++;
			
			if (input >= start && input <= end) {
				if (input == 1) {
					System.out.println(1);
				}else if(input <1) {
					System.out.println(0);
				}else {
					System.out.println((count+1));
				}
				flag = false;
			}
		}
	}
}

// 타인 풀이

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         
        int rslt = 1;
        int roomNum = 1;
        int addNum = 6;
        while(true) {
            if(n <= roomNum) {
                break;
            }
             
            roomNum += addNum;
            addNum += 6;
            rslt++;
        }
        System.out.println(rslt);
    }
}

출처:http:// hianna.tistory.com/160 [어제 오늘 내일]
