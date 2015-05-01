package Sunshine;

import java.util.Scanner;

public class Demo {

public static void main(String[] args) {

// TODO Auto-generated method stub

        Scanner scan=new Scanner(System.in);
        
        System.out.println("请输入一个年份：");
        
        long year;
        
        try{
        
        year=scan.nextLong();
        
        if ((year%4==0)&&(year%100!=0)) {
        
System.out.println(year+"是闰年");

}
else{

System.out.println(year+"不是闰年");

}

        }catch(Exception e){
        
        System.out.println("你输入的不是有效年份！");
        
        }
        
}

}