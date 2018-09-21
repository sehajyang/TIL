package baekjoonStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution1406 {
	//°íÄ¥°Å
    public static void main(String[] args) throws IOException{

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String t = "";
        Stack<Character> ch = new Stack<>();
        Stack<Character> tmp = new Stack<>();
        {
            String v = s.readLine();s.skip(0);
            for (int i = 0; i < v.length(); i++) {
                ch.push(v.charAt(i));
            }
        }
        int cc = Integer.parseInt(s.readLine());s.skip(0);
            int chsize = ch.size();
            int tmpsize = 0;
        while (cc-- != 0) {
            t = s.readLine();s.skip(0);
            char[] x = t.toCharArray();
            //System.out.printf("asdfsda %c\n", x[0]);
            switch(x[0]){
                case 'L':
                	if(chsize != 0){
                		char d = ch.pop();
                		chsize--;
                    	tmp.push(d);
                    	tmpsize++;
                    }
                    break;
                case 'D':
                	if(tmpsize != 0){
                		char d = tmp.pop();
                		tmpsize--;
                    	ch.push(d);
                    	chsize++;
                    }
                    break;
                case 'B':
                	if(chsize != 0){
                	    //System.out.printf("%c\n",
                	    chsize--;
                	    ch.pop();
                	    
                	    //)
                	    //;
                	   }
                    break;
                case 'P':
                    for(int i=2;i<x.length;i++){
                        ch.push(x[i]);
                        chsize++;
                        i++; // skip ' '
                    }
                    break;
            }
        }
            int ts = tmp.size();
            for(int i=0;i<ts;i++){
            	char d = tmp.pop();
                ch.push(d);
            }
            
            char[] q = new char[ch.size()];
            for(int i=0;i<q.length;i++){
                q[q.length - 1 - i] = ch.pop();
            }
            System.out.println(new String(q));
    }
}