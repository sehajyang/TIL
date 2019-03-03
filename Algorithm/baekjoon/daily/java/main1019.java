/*
 * 18-10-10
 * 백준 1019
 * 둘째자리까지만 됨
 * */

package daily.java;

public class main1019 {
	public static void main(String[] args) {
		int in10 = 100;
		int rst = (in10/(int)Math.pow(10, (int)(Math.log10(in10)))); //첫자리수
		int rst2 = (in10%(int)Math.pow(10, (int)(Math.log10(in10)))); //둘째자리 수
		
		int[] arr = new int[1000];
		
			for (int i = 0; i < 10; i++) {
				arr[i] =rst+1;
				
				for (int j = 1; j < (in10/(int)Math.pow(10, (int)(Math.log10(in10)))+1); j++) {
					arr[j] += (int)Math.pow(10, (int)(Math.log10(in10)))-1;
				}
				
				for (int j = rst2; j < 10; j++) {
					arr[j] -=1;
				}
				System.out.print(arr[i]+" ");
				
			}
		
	}

}
