package baekjoonStudy;
import java.util.*;
public class Main11655 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String result ="";
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c>='a'&&c<='z'){
                c=(char) (((c-97+13)%26)+97);
                result+=c;
            }else if(c>='A'&&c<='Z'){
               c=(char) (((c-65+13)%26)+65);
               result+=c;
            }else if(c==32){
                result+=c;
            }else{
                result+=c;
            }
        }
        System.out.println(result);
        sc.close();
    }
}