package Ajayjava;

import java.util.Scanner;

public class StableunStable {
    public static boolean checkStable(int num){//1212
        int size = 10;
        //int[] a= new int[]{0,0,0,0,0,0,0,0,0,0};{OR}
        int[] a = {0,0,0,0,0,0,0,0,0,0};
        while(num!=0){
            int temp = num%10;
            a[temp]++;
            num /=10;
        }
        int temp = 0,i;
        for(i = 0;i<size;i++){
            if(a[i]==0)
                continue;
            temp = a[i];
            break;
        }
        for(i = 0;i<size;i++){
            if(a[i]==0)
                continue;
            if(temp!=a[i])
               return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[] arr = new int[5];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter five numbers : ");
        for (int i = 0; i < 5; i++)
            arr[i] = in.nextInt();
        int stable = 0, unstable = 0;
        for (int i = 0; i < 5; i++) {
            if (checkStable(arr[i])) {
                stable += arr[i];
            } else
                unstable += arr[i];
        }
        System.out.print("The Password is : ");
        System.out.println(stable * 2 - unstable);//my logic to find the password;
        System.out.println("Credits Ajay Sairam N");

    }
}
