package Ajayjava;
import java.util.Scanner;
public class digit_manipulation {
    public static void main(String[] args){
        int pv=1,count=0,ld=0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number to be reversed: ");
        int num = in.nextInt();//2345
        while(num/pv!=0){
            count++;
            pv = pv*10;
        }
        if(count%2==1){
             ld=num%10;
            num=num/10;
        }
        pv=1;
        int res=0,swap;
        while(num!=0){
            int dig=num%100;//45
            swap=(dig%10)*10+(dig/10);//54
            res=swap*pv+res;
            pv*=100;
            num/=pv;
        }
        if(count%2==1){
            System.out.print(res*10+ld);
        }
        else{
            System.out.println(res);
        }


    }
}
