package baekjoonStudy;

import java.util.*;

public class Main{
    
    public static void main(String[] args){
        //size 입력하면 그만큼 랜덤 생성해서 다 더하는 것
        Scanner sc = new Scanner(System.in);
        int input_num = sc.nextInt();
        int array[];
        int sum = 0;
        
        array = new int[input_num];
        
        for (int i = 0; i < input_num; i++) {
            int random_num= (int) (Math.random() * 10) + 1;
            
            array[i] = random_num;
            sum += random_num;
            System.out.println(array[i]);
           
        }
        System.out.println("sum"+sum);
    }
}