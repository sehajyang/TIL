package daily.java;


public class main1019 {
	public static void main(String[] args) {
		int in  =22;
		int in10 = 33;
		int in100 = 119;
		
		int[] arr = new int[1000];
		
		if(in < 10) {
			for (int i = 0; i < 10; i++) {
				arr[i] = 1;
			}
			
		}else if(in10 <100 && in10 > 9) {
			for (int i = 0; i < 10; i++) {
				arr[i] = (in10/(int)Math.pow(10, (int)(Math.log10(in10))))+1;
				for (int j = 1; j <  (in10/(int)Math.pow(10, (int)(Math.log10(in10)))+1); j++) {
					arr[j] += (int)Math.pow(10, (int)(Math.log10(in10)));
				}
				arr[(in10/(int)Math.pow(10, (int)(Math.log10(in10))))-1] -=1;
				System.out.print(arr[i]+" ");
				
			}
		}
		
	}

}
