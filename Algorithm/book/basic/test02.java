package book;

public class test02 {
	static int min4(int a, int b, int c, int d) {
		int min;
		min = a;
		if(min >b) 
			min = b;
		if(min >c)
			min = c;
		if(min >d)
			min = d;
		return min;
		
	}
	public static void main(String args[]) {
		System.out.println(test02.min4(-111, 0, 1,2));
	}
}
