package Sunshine;

import java.util.Scanner;

public class Demo {

public static void main(String[] args) {

// TODO Auto-generated method stub

        Scanner scan=new Scanner(System.in);
        
        System.out.println("������һ����ݣ�");
        
        long year;
        
        try{
        
        year=scan.nextLong();
        
        if ((year%4==0)&&(year%100!=0)) {
        
System.out.println(year+"������");

}
else{

System.out.println(year+"��������");

}

        }catch(Exception e){
        
        System.out.println("������Ĳ�����Ч��ݣ�");
        
        }
        
}

}