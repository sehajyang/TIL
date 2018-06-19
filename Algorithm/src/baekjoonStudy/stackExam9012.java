package baekjoonStudy;
import java.util.*;

public class stackExam9012 {

	    static String arr;
	    public static void main(String args[]){
	        Scanner sc=new Scanner(System.in);
	        int n = sc.nextInt();
	        for(int i=0;i<n;i++){
	             arr=sc.next();
	             System.out.println(isVPS(arr));
	        }
	    }
	    static String isVPS(String array){
	        int k=0;
	        for(int i=0;i<array.length();i++){
	            if(array.charAt(i)=='('){
	               k++;
	            }else if(array.charAt(i)==')'){
	               k--;
	            }
	            if(k<0)
	                return "NO";
	        }
	        if(k==0)
	            return "YES";
	        else
	            return "NO";
	    }
	}
