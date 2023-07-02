package virtusa.abstract_;

import java.util.*;
public class Main_1{
    public static int getLargest(int[] a, int total){
        Arrays.sort(a);
        return a[total-1];
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t,q;
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]= in.nextInt();
            if(n%2!=0){
                System.out.print("Enter valid number");
                return;
            }
        }
        System.out.print(getLargest(a,n-1)+" ");
        System.out.print(getLargest(a,n)+" ");
    }
}