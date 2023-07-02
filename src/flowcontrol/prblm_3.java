package flowcontrol;


import java.util.Scanner;

public class prblm_3 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String str=sc.next();
        if(args.length>0){ //doubt?
            for(int i=0;i< args.length;i++){
                System.out.print(args[i]);
                if(i<args.length-1)
                    System.out.print(", ");
                else
                    System.out.println();
            }
        }
        else
            System.out.print("No values");
    }
}
