package baekjoonStudy;

import java.util.*;

public class Exam1406 {
	//ÇØ°á¾ÈµÊ
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Stack<String> left = new Stack<String>();
        Stack<String> right = new Stack<String>();
        String s=sc.next();
        for(int i=0;i<s.length();i++){
            left.push(s.charAt(i)+"");
        }
        int n=Integer.parseInt(sc.next());
        for(int j=0;j<n;j++){
            String cmd=sc.next();
            if(cmd.equals("L")){
                if(!left.empty()){
                    right.push(left.peek());
                    left.pop();
                }
            }else if(cmd.equals("D")){
                if(right.empty()){
                    left.push(right.peek());
                    right.pop();
                }
            }else if(cmd.equals("P")){
                String p=sc.next();
                left.push(p);
            }else if(cmd.equals("B")){
                if(!left.empty()){
                    left.pop();
                }
            }
        }

        String x="";
        while(!left.empty()){
            x=left.peek()+x;
            left.pop();
        }
        
        while(!right.empty()){
            x=x+right.peek();
            right.pop();
        }
        System.out.println(x);
        sc.close();
    }
}