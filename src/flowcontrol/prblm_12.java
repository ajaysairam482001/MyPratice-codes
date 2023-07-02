package flowcontrol;

import java.util.Scanner;

public class prblm_12 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = in.nextInt();
        int isPrime = 1;
        for(int i=2;i<=num/2;i++){
            if(num==2)
                break;
            if(num%i==0) {
                isPrime = 0;
                break;
            }
        }
        if(isPrime==1)
            System.out.print("Prime number");
        else
            System.out.print("Not a Prime number");
    }
}
