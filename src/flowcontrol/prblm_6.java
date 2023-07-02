package flowcontrol;

import java.util.Scanner;

public class prblm_6 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Male or Female: ");
        String s1 = in.next();
        System.out.println("Enter a age: ");
        int age = in.nextInt();
        String s3 = "Female";
        if(s3.equals(s1)){
            if(age>=1&&age<=58)
                System.out.println("the percentage of interest is 8.2%");
            else if (age>=59&&age<=100)
                System.out.println("the percentage of interest is 9.2%");
        }
        else{
            if(age>=1&&age<=58)
                System.out.println("the percentage of interest is 8.4%");
            else if (age>=59&&age<=100)
                System.out.println("the percentage of interest is 10.5%");
        }
    }

}
